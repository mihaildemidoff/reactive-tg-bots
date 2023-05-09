package io.github.mihaildemidoff.reactive.tg.bots.examples.simple.command;

import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Mono;

public interface CommandHandler {

    Mono<Boolean> handle(Update update);

    String getCommand();

    String getDescription();

}
