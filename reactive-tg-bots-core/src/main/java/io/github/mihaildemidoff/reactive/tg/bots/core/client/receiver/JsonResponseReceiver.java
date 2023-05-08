package io.github.mihaildemidoff.reactive.tg.bots.core.client.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.ResponseDeserializationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClientResponse;

import java.io.InputStream;
import java.util.function.BiFunction;

/**
 * Json response deserializer. Deserializes response as RESPONSE
 *
 * @param <RESPONSE> response type
 */
@RequiredArgsConstructor
public class JsonResponseReceiver<RESPONSE> implements BiFunction<HttpClientResponse, ByteBufMono, Mono<GenericBotApiResponse<RESPONSE>>> {

    /**
     * ObjectMapper
     */
    @NotNull
    private final ObjectMapper objectMapper;

    /**
     * Method
     */
    @NotNull
    private final BaseBotMethodDefinition<RESPONSE> method;

    @Override
    public Mono<GenericBotApiResponse<RESPONSE>> apply(final HttpClientResponse httpClientResponse,
                                                       final ByteBufMono byteBufMono) {
        return byteBufMono
                .asInputStream()
                .flatMap(is -> readJson(method, is));
    }

    /**
     * Deserializes response of method.  Method throws {@link ResponseDeserializationException} in case of any error
     * during response deserialization
     *
     * @param method telegram method
     * @param is     InputStream with response
     * @return Mono with deserialized response
     */
    private Mono<GenericBotApiResponse<RESPONSE>> readJson(final BaseBotMethodDefinition<RESPONSE> method,
                                                           final InputStream is) {
        return Mono.fromCallable(() -> {
            try {
                return objectMapper.readValue(is, method.getResponseClass());
            } catch (final Exception e) {
                throw new ResponseDeserializationException(String.format("Error during response deserialization. Class: %s, method: %s", method.getResponseClass(), method.getMethod()), e);
            }
        });
    }

}
