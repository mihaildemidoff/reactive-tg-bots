package io.github.mihaildemidoff.reactive.tg.bots.core.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.receiver.JsonResponseReceiver;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.sender.JsonSender;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.sender.MultipartSender;
import io.github.mihaildemidoff.reactive.tg.bots.core.exception.UnsuccessfulBotMethodInvocationException;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.api.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.ByteArrayInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMeMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendPhotoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;
import reactor.test.StepVerifier;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@SuppressWarnings({"rawtypes", "unchecked"})
@ExtendWith(MockitoExtension.class)
class DefaultTelegramClientTest {

    @InjectMocks
    private DefaultTelegramClient client;

    @Mock
    private TelegramBotProperties properties;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private HttpClient httpClient;

    @Mock
    private ValidationService validationService;

    @Test
    void testExecuteSuccessNonMultipart() {
        final GetMeMethod method = GetMeMethod.builder()
                .build();
        final GenericBotApiResponse<User> response = GenericBotApiResponse.<User>builder()
                .ok(true)
                .result(User.builder()
                        .build())
                .build();
        final Duration timeout = Duration.ofSeconds(10);
        final HttpClient.RequestSender requestSender = Mockito.mock(HttpClient.RequestSender.class);
        final String token = RandomStringUtils.randomAlphabetic(10);
        final HttpClient.ResponseReceiver responseReceiver = Mockito.mock(HttpClient.ResponseReceiver.class);
        Mockito.when(properties.getToken())
                .thenReturn(token);
        Mockito.when(httpClient.responseTimeout(ArgumentMatchers.eq(timeout)))
                .thenReturn(httpClient);
        Mockito.when(httpClient.post())
                .thenReturn(requestSender);
        Mockito.when(requestSender.uri(ArgumentMatchers.eq(String.format("/bot%s/%s", properties.getToken(), method.getMethod().getMethodName()))))
                .thenReturn(requestSender);
        Mockito.when(requestSender.send(ArgumentMatchers.any(JsonSender.class)))
                .thenReturn(responseReceiver);
        Mockito.when(responseReceiver.responseSingle(ArgumentMatchers.any(JsonResponseReceiver.class)))
                .thenReturn(Mono.just(response));
        StepVerifier.create(client.executeMethod(method, timeout))
                .expectSubscription()
                .expectNext(response.getResult())
                .verifyComplete();
        Mockito.verify(validationService, Mockito.times(1))
                .validateMethod(ArgumentMatchers.eq(method));
    }

    @Test
    void testExecuteSuccessMultipart() {
        final SendPhotoMethod method = SendPhotoMethod.builder()
                .photo(ByteArrayInputFile.builder()
                        .build())
                .build();
        final GenericBotApiResponse<Message> response = GenericBotApiResponse.<Message>builder()
                .ok(true)
                .result(Message.builder()
                        .build())
                .build();
        final Duration timeout = Duration.ofSeconds(10);
        final HttpClient.RequestSender requestSender = Mockito.mock(HttpClient.RequestSender.class);
        final String token = RandomStringUtils.randomAlphabetic(10);
        final HttpClient.ResponseReceiver responseReceiver = Mockito.mock(HttpClient.ResponseReceiver.class);
        Mockito.when(properties.getToken())
                .thenReturn(token);
        Mockito.when(httpClient.responseTimeout(ArgumentMatchers.eq(timeout)))
                .thenReturn(httpClient);
        Mockito.when(httpClient.post())
                .thenReturn(requestSender);
        Mockito.when(requestSender.uri(ArgumentMatchers.eq(String.format("/bot%s/%s", properties.getToken(), method.getMethod().getMethodName()))))
                .thenReturn(requestSender);
        Mockito.when(requestSender.sendForm(ArgumentMatchers.any(MultipartSender.class)))
                .thenReturn(responseReceiver);
        Mockito.when(responseReceiver.responseSingle(ArgumentMatchers.any(JsonResponseReceiver.class)))
                .thenReturn(Mono.just(response));
        StepVerifier.create(client.executeMethod(method, timeout))
                .expectSubscription()
                .expectNext(response.getResult())
                .verifyComplete();
        Mockito.verify(validationService, Mockito.times(1))
                .validateMethod(ArgumentMatchers.eq(method));
    }

    @Test
    void testExecuteNonSuccess() {
        final GetMeMethod method = GetMeMethod.builder()
                .build();
        final GenericBotApiResponse<User> response = GenericBotApiResponse.<User>builder()
                .ok(false)
                .errorCode(RandomUtils.nextLong())
                .description(RandomStringUtils.randomAlphabetic(10))
                .result(User.builder()
                        .build())
                .build();
        final Duration timeout = Duration.ofSeconds(10);
        final HttpClient.RequestSender requestSender = Mockito.mock(HttpClient.RequestSender.class);
        final String token = RandomStringUtils.randomAlphabetic(10);
        final HttpClient.ResponseReceiver responseReceiver = Mockito.mock(HttpClient.ResponseReceiver.class);
        Mockito.when(properties.getToken())
                .thenReturn(token);
        Mockito.when(httpClient.responseTimeout(ArgumentMatchers.eq(timeout)))
                .thenReturn(httpClient);
        Mockito.when(httpClient.post())
                .thenReturn(requestSender);
        Mockito.when(requestSender.uri(ArgumentMatchers.eq(String.format("/bot%s/%s", properties.getToken(), method.getMethod().getMethodName()))))
                .thenReturn(requestSender);
        Mockito.when(requestSender.send(ArgumentMatchers.any(JsonSender.class)))
                .thenReturn(responseReceiver);
        Mockito.when(responseReceiver.responseSingle(ArgumentMatchers.any(JsonResponseReceiver.class)))
                .thenReturn(Mono.just(response));
        StepVerifier.create(client.executeMethod(method, timeout))
                .expectSubscription()
                .expectErrorMatches(error -> error instanceof UnsuccessfulBotMethodInvocationException
                        && ((UnsuccessfulBotMethodInvocationException) error).getErrorCode().equals(response.getErrorCode())
                        && ((UnsuccessfulBotMethodInvocationException) error).getDescription().equals(response.getDescription()))
                .verify();
        Mockito.verify(validationService, Mockito.times(1))
                .validateMethod(ArgumentMatchers.eq(method));
    }

    @Test
    void testGetFileAsInputStream() {
        final String token = RandomStringUtils.randomAlphabetic(10);
        final String filePath = RandomStringUtils.randomAlphabetic(10);
        final File request = File.builder()
                .filePath(filePath)
                .build();
        final HttpClient.ResponseReceiver responseReceiver = Mockito.mock(HttpClient.ResponseReceiver.class);
        Mockito.when(httpClient.get())
                .thenReturn(responseReceiver);
        Mockito.when(properties.getToken())
                .thenReturn(token);
        Mockito.when(responseReceiver.uri(ArgumentMatchers.eq(String.format("/file/bot%s/%s", token, filePath))))
                .thenReturn(responseReceiver);
        final String response = RandomStringUtils.randomAlphabetic(10);
        Mockito.when(responseReceiver.responseContent())
                .thenReturn(ByteBufFlux.fromString(Mono.just(response)));
        StepVerifier.create(client.getFileAsInputStream(request))
                .expectSubscription()
                .expectNextMatches(is -> matchInputStreamResponse(response, is))
                .verifyComplete();
    }

    @SneakyThrows
    private static boolean matchInputStreamResponse(final String response, final InputStream is) {
        return new String(is.readAllBytes(), StandardCharsets.UTF_8).equals(response);
    }


}
