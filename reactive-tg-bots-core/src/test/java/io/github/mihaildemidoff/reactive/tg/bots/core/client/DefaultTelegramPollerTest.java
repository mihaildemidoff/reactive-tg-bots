package io.github.mihaildemidoff.reactive.tg.bots.core.client;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.GetUpdatesMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@ExtendWith(MockitoExtension.class)
class DefaultTelegramPollerTest {

    @InjectMocks
    private DefaultTelegramPoller poller;

    @Mock
    private TelegramClient client;

    @Mock
    private TelegramBotProperties properties;

    @Test
    void testUpdatesPublisher() {
        Mockito.when(properties.getLongPollingTimeout())
                .thenReturn(Duration.ofSeconds(10));
        final Set<Long> offsets = new HashSet<>();
        final List<Update> updates = LongStream.range(0, 40)
                .mapToObj(val -> Update
                        .builder()
                        .updateId(val)
                        .build())
                .collect(Collectors.toList());
        Mockito.when(client.executeMethod(ArgumentMatchers.argThat((BaseBotMethodDefinition<?> argument) -> {
                    final GetUpdatesMethod method = (GetUpdatesMethod) argument;
                    return method.getTimeout().equals(10L) && method.getOffset() != null;
                }), ArgumentMatchers.eq(Duration.ofSeconds(15))))
                .thenAnswer((Answer<Mono<List<Update>>>) invocation -> {
                    final GetUpdatesMethod method = invocation.getArgument(0);
                    if (!offsets.contains(method.getOffset())) {
                        offsets.add(method.getOffset());
                        throw new RuntimeException("Test exception");
                    }
                    final int count = RandomUtils.nextInt(1, 4);
                    return Mono.just(updates.subList(method.getOffset().intValue(), method.getOffset().intValue() + count));
                });
        StepVerifier.create(poller.getUpdatesPublisher(), 30)
                .expectSubscription()
                .expectNextSequence(updates.subList(0, 30))
                .thenCancel()
                .verify();
    }

}
