package io.github.mihaildemidoff.reactive.tg.bots.core.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.sender.JsonSender;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.sender.MultipartSender;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.ResponseDeserializationException;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.UnsuccessfulBotMethodInvocationException;
import io.github.mihaildemidoff.reactive.tg.bots.core.http.HttpClientBuilder;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.NoOpValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.file.GetFileMethod;
import io.netty.handler.codec.http.QueryStringEncoder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Objects;

/**
 * Telegram client implementation.
 */
@Slf4j
public class DefaultTelegramClient implements TelegramClient {

    /**
     * Telegram bot properties.
     */
    private final TelegramBotProperties properties;

    /**
     * Jackson object mapper.
     */
    private final ObjectMapper objectMapper;

    /**
     * Netty http client.
     */
    private final HttpClient httpClient;

    /**
     * Validation service.
     */
    private final ValidationService validationService;

    /**
     * Creates new telegram client with default http client and without enabled validation.
     *
     * @param properties client properties
     */
    public DefaultTelegramClient(final TelegramBotProperties properties) {
        this(properties, HttpClientBuilder.defaultHttpClient(properties.getBaseUrl(), properties.getTimeout()), new NoOpValidationService());
    }

    /**
     * Creates new telegram client.
     * Pass validationService instance if you want to enable validation of outgoing requests.
     *
     * @param properties        client properties, required
     * @param httpClient        http client, required
     * @param validationService validationService, could be null
     */
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public DefaultTelegramClient(@NotNull final TelegramBotProperties properties,
                                 @NotNull final HttpClient httpClient,
                                 final ValidationService validationService) {
        this.properties = properties;
        this.httpClient = httpClient;
        this.objectMapper = createObjectMapper();
        this.validationService = validationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <RESPONSE> Mono<RESPONSE> executeMethod(final BaseBotMethodDefinition<RESPONSE> method) {
        return executeMethod(method, properties.getTimeout());
    }

    /**
     * {@inheritDoc}
     */
    @Valid
    public <RESPONSE> Mono<RESPONSE> executeMethod(final BaseBotMethodDefinition<RESPONSE> method,
                                                   final Duration timeout) {
        final HttpClient.RequestSender baseRequest = httpClient
                .responseTimeout(timeout)
                .post()
                .uri(buildUri(method.getMethod().getMethodName()));
        final HttpClient.ResponseReceiver<?> responseReceiver = getResponseReceiver(baseRequest, method);
        return responseReceiver
                .responseSingle((httpClientResponse, byteBufMono) -> byteBufMono
                        .asInputStream()
                        .map(is -> readJson(method, is)))
                .flatMap(response -> {
                    if (!Objects.equals(response.getOk(), Boolean.TRUE)) {
                        return Mono.error(new UnsuccessfulBotMethodInvocationException("Error response", response.getErrorCode(), response.getDescription()));
                    } else {
                        return Mono.just(response.getResult());
                    }
                })
                .doOnEach(r -> log.debug("Response: {}", r));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<ByteBuffer> getFileAsByteBuffer(final File file) {
        return httpClient
                .get()
                .uri(buildFileUri(file.getFilePath()))
                .responseContent()
                .asByteBuffer();
    }

    @Override
    public Flux<ByteBuffer> getFileAsByteBuffer(final String fileId) {
        return executeMethod(GetFileMethod.builder()
                .fileId(fileId)
                .build())
                .flatMapMany(this::getFileAsByteBuffer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<InputStream> getFileAsInputStream(final File file) {
        return httpClient
                .get()
                .uri(buildFileUri(file.getFilePath()))
                .responseContent()
                .aggregate()
                .asInputStream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<InputStream> getFileAsInputStream(final String fileId) {
        return executeMethod(GetFileMethod.builder()
                .fileId(fileId)
                .build())
                .flatMap(this::getFileAsInputStream);
    }

    /**
     * Deserializes response of method.  Method throws {@link ResponseDeserializationException} in case of any error
     * during response deserialization
     *
     * @param method     telegram method
     * @param is         InputStream with response
     * @param <RESPONSE> response class
     * @return Mono with deserialized response
     */
    private <RESPONSE> GenericBotApiResponse<RESPONSE> readJson(final BaseBotMethodDefinition<RESPONSE> method,
                                                                final InputStream is) {
        try {
            return objectMapper.readValue(is, method.getResponseClass());
        } catch (final Exception e) {
            throw new ResponseDeserializationException(String.format("Error during response deserialization. Class: %s, method: %s", method.getResponseClass(), method.getMethod()), e);
        }
    }

    /**
     * Build telegram path uri in form: '/bot`token`/`method`'
     *
     * @param method method name
     * @return built uri
     */
    private String buildUri(final String method) {
        final QueryStringEncoder encoder = new QueryStringEncoder(String.format("/bot%s/%s", properties.getToken(), method));
        return encoder.toString();
    }

    /**
     * Build file uri.
     *
     * @param filePath filePath property from {@link File}
     * @return built file uri
     */
    private String buildFileUri(final String filePath) {
        return String.format("/file/bot%s/%s", properties.getToken(), filePath);
    }

    private <RESPONSE> HttpClient.ResponseReceiver<?> getResponseReceiver(final HttpClient.RequestSender baseRequest,
                                                                          final BaseBotMethodDefinition<RESPONSE> method) {
        final HttpClient.ResponseReceiver<?> responseReceiver;
        if (method.isMultipartMethod()) {
            responseReceiver = baseRequest.sendForm(new MultipartSender(objectMapper, (BaseBotMediaMethodDefinition<RESPONSE>) method));
        } else {
            responseReceiver = baseRequest.send(new JsonSender(objectMapper, method));
        }
        return responseReceiver;
    }

    /**
     * Creates default object mapper.
     *
     * @return object mapper
     */
    private ObjectMapper createObjectMapper() {
        final JsonMapper mapper = JsonMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
