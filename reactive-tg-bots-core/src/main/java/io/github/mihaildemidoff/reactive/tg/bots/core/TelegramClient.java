package io.github.mihaildemidoff.reactive.tg.bots.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.ResponseDeserializationException;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.UnsuccessfulBotMethodInvocationException;
import io.github.mihaildemidoff.reactive.tg.bots.core.http.HttpClientBuilder;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.NoOpValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.GetUpdatesMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.UpdateType;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.QueryStringEncoder;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.logging.ReactorNettyHttpMessageLogFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Telegram client implementation.
 */
@Slf4j
public class TelegramClient {

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
    public TelegramClient(final TelegramBotProperties properties) {
        this(properties, HttpClientBuilder.defaultHttpClient(properties.getTimeout()), new NoOpValidationService());
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
    public TelegramClient(@NotNull final TelegramBotProperties properties,
                          @NotNull final HttpClient httpClient,
                          final ValidationService validationService) {
        this.properties = properties;
        this.httpClient = httpClient;
        this.objectMapper = createObjectMapper();
        this.validationService = validationService;
    }

    /**
     * Get infinite publisher with telegram updates.
     * TODO: add documentation
     *
     * @return publisher with updates
     */
    public Flux<Update> getUpdatesPublisher() {
        return getUpdatesPublisher(List.of());
    }

    /**
     * Get infinite publisher with telegram updates.
     * TODO: add documentation
     *
     * @param allowedUpdates list of allowed(filtered) updates. Pass empty list to get all updates
     * @return publisher with updates
     */
    public Flux<Update> getUpdatesPublisher(final List<UpdateType> allowedUpdates) {
        return Flux.generate(() -> 0L, (state, sink) -> {
                    try {
                        final GetUpdatesMethod request = GetUpdatesMethod.builder()
                                .offset(state)
                                .timeout(properties.getLongPollingTimeout().toSeconds())
                                .allowedUpdates(allowedUpdates)
                                .build();
                        final List<Update> updates = Optional.ofNullable(prepareRequest(request, Duration.ofSeconds((int) (request.getTimeout() * 1.5)))
                                        .share()
                                        .block())
                                .orElse(List.of());
                        final Long newUpdateId = calculateOffset(state, updates);
                        sink.next(updates);
                        return newUpdateId;
                    } catch (final Exception e) {
                        log.error("Error occurred during getting long-polling updates", e);
                        sink.next(List.of());
                        return state;
                    }
                })
                .subscribeOn(Schedulers.newSingle("tg", false))
                .map(it -> (List<Update>) it)
                .flatMapIterable(it -> it);
    }

    /**
     * Execute telegram method.
     *
     * @param method     method to execute
     * @param <RESPONSE> expected response
     * @return Mono with deserialized response or Mono.error.
     * See {@link io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException} for all possible errors.
     * @see io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException
     */
    public <RESPONSE> Mono<RESPONSE> executeMethod(final BaseBotMethodDefinition<RESPONSE> method) {
        return prepareRequest(method, properties.getTimeout());
    }

    /**
     * Method prepares http request to telegram server.
     *
     * @param method     method to execute
     * @param timeout    response timeout
     * @param <RESPONSE> method response class
     * @return Mono with response
     */

    private <RESPONSE> Mono<RESPONSE> prepareRequest(final BaseBotMethodDefinition<RESPONSE> method,
                                                     final Duration timeout) {
        validationService.validateMethod(method);
        final JsonNode methodJsonTree = objectMapper.valueToTree(method);
        log.debug("Serialized request to telegram. Method: {}, body: {}", method.getMethod(), methodJsonTree);
        final List<InputFile> inputFiles = findAllInputFiles(method);
        final boolean isMultipart = inputFiles.stream()
                .anyMatch(InputFile::isMultipart);
        final HttpClient.RequestSender baseRequest = httpClient
                .baseUrl(properties.getBaseUrl())
                .wiretap(true)
                .httpMessageLogFactory(new ReactorNettyHttpMessageLogFactory())
                .responseTimeout(timeout)
                .headers(entries -> {
                    if (!isMultipart) {
                        entries.add("Content-Type", "application/json");
                    }
                })
                .post()
                .uri(buildUri(properties.getToken(), method.getMethod().getMethodName()));
        final HttpClient.ResponseReceiver<?> responseReceiver;
        if (isMultipart) {
            responseReceiver = baseRequest.sendForm((httpClientRequest, httpClientForm) -> {
                httpClientForm.multipart(true);
                for (final Iterator<Map.Entry<String, JsonNode>> it = methodJsonTree.fields(); it.hasNext(); ) {
                    final Map.Entry<String, JsonNode> node = it.next();
                    if (node.getValue() instanceof TextNode) {
                        httpClientForm.attr(node.getKey(), node.getValue().asText());
                    } else {
                        httpClientForm.attr(node.getKey(), node.getValue().toString());
                    }
                }
                for (final InputFile file : inputFiles) {
                    if (file != null && file.isMultipart()) {
                        httpClientForm.file(file.getFileName(), file.getFileName(), file.getFileInputStream(), file.getMimeType());
                    }
                }
            });
        } else {
            responseReceiver = baseRequest
                    .send(Mono.just(Unpooled.wrappedBuffer(methodJsonTree.toString().getBytes(StandardCharsets.UTF_8))));
        }
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
                .doOnEach(r -> log.error("Response: {}", r));
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
     * Calcualtes next offset based on last state. Offset calculated as max(update_id) + 1.
     * If list of updates is empty then offset is returned
     *
     * @param state   current state
     * @param updates list of updates
     * @return next offset
     */
    private Long calculateOffset(final Long state, final List<Update> updates) {
        return updates.stream()
                .max(Comparator.comparingLong(Update::getUpdateId))
                .map(Update::getUpdateId)
                .map(id -> id + 1)
                .orElse(state);
    }

    /**
     * Build telegram path uri in form: '/bot`token`/`method`'
     *
     * @param tgToken bot secret token
     * @param method  method name
     * @return built uri
     */
    private String buildUri(final String tgToken,
                            final String method) {
        final QueryStringEncoder encoder = new QueryStringEncoder(String.format("/bot%s/%s", tgToken, method));
        return encoder.toString();
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

    /**
     * Finds all {@link InputFile} from method.
     *
     * @param method     method definition
     * @param <RESPONSE> method response type
     * @return all found input files
     */
    private <RESPONSE> List<InputFile> findAllInputFiles(final BaseBotMethodDefinition<RESPONSE> method) {
        if (method.isMediaMethod() && method instanceof BaseBotMediaMethodDefinition) {
            return ((BaseBotMediaMethodDefinition<RESPONSE>) method).getAllInputFiles();
        }
        return List.of();
    }
}
