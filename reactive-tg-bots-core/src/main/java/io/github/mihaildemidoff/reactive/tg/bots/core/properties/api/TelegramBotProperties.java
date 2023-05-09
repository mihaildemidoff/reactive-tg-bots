package io.github.mihaildemidoff.reactive.tg.bots.core.properties.api;

import java.time.Duration;

public interface TelegramBotProperties {

    String getBaseUrl();

    String getToken();

    Duration getTimeout();

    Duration getLongPollingTimeout();
}
