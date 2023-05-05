package io.github.mihaildemidoff.reactive.tg.bots.core.client.sender;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMediaMethodDefinition;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.client.HttpClientForm;
import reactor.netty.http.client.HttpClientRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Sends method as multipart/form-data request.
 */
@RequiredArgsConstructor
public class MultipartSender implements BiConsumer<HttpClientRequest, HttpClientForm> {

    @NotNull
    private final ObjectMapper objectMapper;

    @NotNull
    private final BaseBotMediaMethodDefinition<?> method;

    @Override
    public void accept(final HttpClientRequest httpClientRequest,
                       final HttpClientForm httpClientForm) {
        final JsonNode methodJsonTree = objectMapper.valueToTree(method);
        httpClientForm.multipart(true);
        for (final Iterator<Map.Entry<String, JsonNode>> it = methodJsonTree.fields(); it.hasNext(); ) {
            final Map.Entry<String, JsonNode> node = it.next();
            if (node.getValue() instanceof TextNode) {
                httpClientForm.attr(node.getKey(), node.getValue().asText());
            } else {
                httpClientForm.attr(node.getKey(), node.getValue().toString());
            }
        }
        Optional.ofNullable(method.getAllInputFiles())
                .orElse(List.of())
                .forEach(file -> {
                    if (file != null && file.isMultipart()) {
                        httpClientForm.file(file.getFileName(), file.getFileName(), file.getFileInputStream(), file.getMimeType());
                    }
                });
    }
}
