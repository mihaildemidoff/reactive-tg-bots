package io.github.mihaildemidoff.reactive.tg.bots.core.client.api;

import io.github.mihaildemidoff.reactive.tg.bots.model.methods.update.UpdateType;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Service that implements updates receiving via long-polling.
 *
 * @see <a href="https://core.telegram.org/bots/api#getupdates">Getting updates</a>
 */
public interface TelegramPoller {

    /**
     * Returns flux with telegram updates.
     * This method uses long-polling technique as described at
     * <a href="https://core.telegram.org/bots/api#getupdates">Getting updates</a> section.
     * This method does not return any error during execution. All errors are logged and skipped.
     * This behavior implemented due to project reactor framework limitations(any error fails the sink)
     *
     * @return flux with updates
     */
    Flux<Update> getUpdatesPublisher();

    /**
     * Returns flux with telegram updates.
     * This method uses long-polling technique as described at
     * <a href="https://core.telegram.org/bots/api#getupdates">Getting updates</a> section.
     * Method does not return any error during execution. All errors are logged and skipped.
     * This behavior implemented due to project reactor framework limitations(any error fails the sink).
     *
     * @param allowedUpdates list of allowed updates
     * @return flux with updates
     * @see io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties#longPollingTimeout
     */
    Flux<Update> getUpdatesPublisher(List<UpdateType> allowedUpdates);

}
