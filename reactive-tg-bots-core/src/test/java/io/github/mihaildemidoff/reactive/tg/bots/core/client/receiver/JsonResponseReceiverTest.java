package io.github.mihaildemidoff.reactive.tg.bots.core.client.receiver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.ResponseDeserializationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClientResponse;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings({"rawtypes", "unchecked"})
@ExtendWith(MockitoExtension.class)
class JsonResponseReceiverTest {

    @InjectMocks
    private JsonResponseReceiver receiver;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BaseBotMethodDefinition method;

    @Test
    void testDeserializationSuccess() throws IOException {
        final HttpClientResponse httpClientResponse = Mockito.mock(HttpClientResponse.class);
        final ByteBufMono byteBufMono = Mockito.mock(ByteBufMono.class);
        final InputStream is = Mockito.mock(InputStream.class);
        final TypeReference typeReference
                = Mockito.mock(TypeReference.class);
        Mockito.when(method.getResponseClass())
                .thenReturn(typeReference);
        Mockito.when(byteBufMono.asInputStream())
                .thenReturn(Mono.just(is));
        final GenericBotApiResponse<Object> response = GenericBotApiResponse.builder()
                .build();
        Mockito.when(objectMapper.readValue(ArgumentMatchers.eq(is), ArgumentMatchers.eq(typeReference)))
                .thenReturn(response);
        StepVerifier.create(receiver.apply(httpClientResponse, byteBufMono))
                .expectSubscription()
                .expectNext(response)
                .verifyComplete();
    }

    @Test
    void testDeserializationNonSuccess() throws IOException {
        final HttpClientResponse httpClientResponse = Mockito.mock(HttpClientResponse.class);
        final ByteBufMono byteBufMono = Mockito.mock(ByteBufMono.class);
        final InputStream is = Mockito.mock(InputStream.class);
        final TypeReference typeReference
                = Mockito.mock(TypeReference.class);
        Mockito.when(byteBufMono.asInputStream())
                .thenReturn(Mono.just(is));
        Mockito.when(method.getResponseClass())
                .thenReturn(typeReference);
        Mockito.when(objectMapper.readValue(ArgumentMatchers.eq(is), ArgumentMatchers.eq(typeReference)))
                .thenThrow(new RuntimeException());
        StepVerifier.create(receiver.apply(httpClientResponse, byteBufMono))
                .expectSubscription()
                .verifyError(ResponseDeserializationException.class);
    }

}
