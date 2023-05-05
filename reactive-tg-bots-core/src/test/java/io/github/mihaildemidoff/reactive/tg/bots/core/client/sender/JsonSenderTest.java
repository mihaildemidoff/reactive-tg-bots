package io.github.mihaildemidoff.reactive.tg.bots.core.client.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.MethodSerializationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.netty.NettyOutbound;
import reactor.netty.http.client.HttpClientRequest;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class JsonSenderTest {

    @InjectMocks
    private JsonSender jsonSender;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BaseBotMethodDefinition<?> method;

    @Mock
    private HttpClientRequest httpClientRequest;

    @Mock
    private NettyOutbound nettyOutbound;

    @Test
    @SuppressWarnings("unchecked")
    void testSendSuccess() throws Exception {
        final String serializedMethod = RandomStringUtils.randomAlphabetic(10);
        final NettyOutbound sendResponse = Mockito.mock(NettyOutbound.class);
        Mockito.when(objectMapper.writeValueAsString(ArgumentMatchers.eq(method)))
                .thenReturn(serializedMethod);
        Mockito.when(nettyOutbound.send(ArgumentMatchers.any()))
                .thenReturn(sendResponse);
        Mockito.when(nettyOutbound.send(ArgumentMatchers.argThat(argument -> {
                    final byte[] array = ((Mono<ByteBuf>) argument)
                            .map(ByteBuf::array)
                            .block();
                    return new String(array, StandardCharsets.UTF_8).equals(serializedMethod);
                })))
                .thenReturn(sendResponse);
        final Publisher<Void> response = jsonSender.apply(httpClientRequest, nettyOutbound);
        assertThat(response, CoreMatchers.is(sendResponse));
        Mockito.verify(httpClientRequest, Mockito.times(1))
                .addHeader(ArgumentMatchers.eq("Content-Type"), ArgumentMatchers.eq("application/json"));
    }

    @Test
    void testSendWithSerializationError() throws Exception {
        Mockito.when(objectMapper.writeValueAsString(ArgumentMatchers.eq(method)))
                .thenThrow(JsonProcessingException.class);
        Assertions.assertThrows(MethodSerializationException.class, () -> jsonSender.apply(httpClientRequest, nettyOutbound));
        Mockito.verify(httpClientRequest, Mockito.times(1))
                .addHeader(ArgumentMatchers.eq("Content-Type"), ArgumentMatchers.eq("application/json"));
    }

}
