package io.github.mihaildemidoff.reactive.tg.bots.core.client;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.GetUpdatesMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.UpdateType;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class DefaultTelegramPoller implements TelegramPoller {

    private final TelegramClient telegramClient;
    private final TelegramBotProperties properties;

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<Update> getUpdatesPublisher() {
        return getUpdatesPublisher(List.of());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Flux<Update> getUpdatesPublisher(final List<UpdateType> allowedUpdates) {
        return Flux.generate(() -> 0L, (state, sink) -> {
                    try {
                        final GetUpdatesMethod request = buildGetUpdatesMethod(allowedUpdates, state);
                        final List<Update> updates = Optional.ofNullable(telegramClient.executeMethod(request,
                                                Duration.ofSeconds((int) (request.getTimeout() * 1.5)))
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

    private GetUpdatesMethod buildGetUpdatesMethod(final List<UpdateType> allowedUpdates, final Long state) {
        return GetUpdatesMethod.builder()
                .offset(state)
                .timeout(properties.getLongPollingTimeout().toSeconds())
                .allowedUpdates(allowedUpdates)
                .build();
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
}
