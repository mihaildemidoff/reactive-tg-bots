package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Mono;

public interface CommandHandler {

    Mono<Boolean> handle(TelegramClient client, Update update);

    String getCommand();

    String getDescription();

}
