package io.github.mihaildemidoff.reactive.tg.bots.core.client.sender;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.netty.http.client.HttpClientForm;
import reactor.netty.http.client.HttpClientRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MultipartSenderTest {

    @InjectMocks
    private MultipartSender multipartSender;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BaseBotMediaMethodDefinition<?> method;

    @Mock
    private HttpClientRequest httpClientRequest;

    @Mock
    private HttpClientForm httpClientForm;

    @Test
    void testSendSuccess() {
        final JsonNode rootNode = Mockito.mock(JsonNode.class);
        final TextNode textNode = Mockito.mock(TextNode.class);
        final JsonNode nonTextNode = Mockito.mock(JsonNode.class);
        final InputFile multipartFile = Mockito.mock(InputFile.class);
        final InputFile nonMultipartFile = Mockito.mock(InputFile.class);
        final InputStream fileInputStream = Mockito.mock(InputStream.class);
        Mockito.when(objectMapper.valueToTree(ArgumentMatchers.eq(method)))
                .thenReturn(rootNode);
        Mockito.when(rootNode.fields())
                .thenReturn(List.of(node("text", textNode), node("nonText", nonTextNode)).iterator());
        final String textNodeValue = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(textNode.asText())
                .thenReturn(textNodeValue);
        final String nonTextNodeValue = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(nonTextNode.toString())
                .thenReturn(nonTextNodeValue);
        Mockito.when(method.getAllInputFiles())
                .thenReturn(new ArrayList<>() {
                    {
                        add(null);
                        add(multipartFile);
                        add(nonMultipartFile);
                    }
                });
        Mockito.when(multipartFile.isMultipart())
                .thenReturn(true);
        final String fileName = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(multipartFile.getFileName())
                .thenReturn(fileName);
        final String mimeType = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(multipartFile.getMimeType())
                .thenReturn(mimeType);
        Mockito.when(multipartFile.getFileInputStream())
                .thenReturn(fileInputStream);
        multipartSender.accept(httpClientRequest, httpClientForm);
        Mockito.verify(httpClientForm, Mockito.times(1))
                .multipart(ArgumentMatchers.eq(true));
        Mockito.verify(httpClientForm, Mockito.times(1))
                .attr(ArgumentMatchers.eq("text"), ArgumentMatchers.eq(textNodeValue));
        Mockito.verify(httpClientForm, Mockito.times(1))
                .attr(ArgumentMatchers.eq("nonText"), ArgumentMatchers.eq(nonTextNodeValue));
        Mockito.verify(httpClientForm, Mockito.times(1))
                .file(ArgumentMatchers.eq(fileName), ArgumentMatchers.eq(fileName), ArgumentMatchers.eq(fileInputStream), ArgumentMatchers.eq(mimeType));
        Mockito.verifyNoMoreInteractions(httpClientForm);
    }

    private Map.Entry<String, JsonNode> node(final String name,
                                             final JsonNode node) {
        return Map.entry(name, node);
    }

}
