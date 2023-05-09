package io.github.mihaildemidoff.reactive.tg.bots.autoconfiguration.properties;

import io.github.mihaildemidoff.reactive.tg.bots.core.properties.api.TelegramBotProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "telegram.bot")
@Getter
@Setter
public class TelegramProperties implements TelegramBotProperties {

    /**
     * Bot secret token. Use @BotFather to create your own bot.
     *
     * @see <a href="https://core.telegram.org/bots#how-do-i-create-a-bot">How Do I Create a Bot?</a>
     */
    private String token;

    /**
     * Default timeout to telegram API. Please keep in mind, that long-polling method will use longPollingTimeout property.
     *
     * @see TelegramBotProperties#getLongPollingTimeout()
     */
    private Duration timeout;

    /**
     * Long polling timeout. Timeout used during long polling requests to telegram.
     */
    private Duration longPollingTimeout;

    /**
     * Base url for telegram API.
     * In case if you don't use Local bot API server set "https://api.telegram.org/"
     *
     * @see <a href="https://core.telegram.org/bots/api#using-a-local-bot-api-server">Using a Local Bot API Server</a>
     */
    private String baseUrl;

}
