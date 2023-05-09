package io.github.mihaildemidoff.reactive.tg.bots.core.properties;

import io.github.mihaildemidoff.reactive.tg.bots.core.properties.api.TelegramBotProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

/**
 * Telegram bot configuration properties.
 */
@AllArgsConstructor
@Getter
public class SimpleBotProperties implements TelegramBotProperties {

    /**
     * Bot secret token. Use @BotFather to create your own bot.
     *
     * @see <a href="https://core.telegram.org/bots#how-do-i-create-a-bot">How Do I Create a Bot?</a>
     */
    private final String token;

    /**
     * Default timeout to telegram API. Please keep in mind, that long-polling method will use longPollingTimeout property.
     *
     * @see TelegramBotProperties#getLongPollingTimeout()
     */
    private final Duration timeout;

    /**
     * Long polling timeout. Timeout used during long polling requests to telegram.
     */
    private final Duration longPollingTimeout;

    /**
     * Base url for telegram API.
     * In case if you don't use Local bot API server set "https://api.telegram.org/"
     *
     * @see <a href="https://core.telegram.org/bots/api#using-a-local-bot-api-server">Using a Local Bot API Server</a>
     */
    private final String baseUrl;
}
