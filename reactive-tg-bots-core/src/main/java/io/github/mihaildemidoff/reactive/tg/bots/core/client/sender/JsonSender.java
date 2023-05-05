package io.github.mihaildemidoff.reactive.tg.bots.core.client.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.MethodSerializationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.netty.buffer.Unpooled;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.netty.NettyOutbound;
import reactor.netty.http.client.HttpClientRequest;

import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;


/**
 * Sends method as json with content-type: application/json
 */
@RequiredArgsConstructor
public class JsonSender implements BiFunction<HttpClientRequest, NettyOutbound, Publisher<Void>> {

    @NotNull
    private final ObjectMapper objectMapper;

    @NotNull
    private final BaseBotMethodDefinition<?> method;

    @Override
    public Publisher<Void> apply(final HttpClientRequest httpClientRequest,
                                 final NettyOutbound nettyOutbound) {
        httpClientRequest.addHeader("Content-Type", "application/json");
        final byte[] requestBytes;
        try {
            requestBytes = objectMapper.writeValueAsString(method).getBytes(StandardCharsets.UTF_8);
        } catch (final Exception e) {
            throw new MethodSerializationException(String.format("Error occurred during method serialization. Method: %s", method.getMethod()), e);
        }
        return nettyOutbound.send(Mono.just(Unpooled.wrappedBuffer(requestBytes)));
    }
}
