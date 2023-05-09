package io.github.mihaildemidoff.reactive.tg.bots.examples.simple.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntityType;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.SetMyDescriptionMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SetDescriptionCommandHandler implements CommandHandler {

    private final TelegramClient client;

    @Override
    public Mono<Boolean> handle(final Update update) {
        final String parameter = update.getMessage().getEntities()
                .stream()
                .filter(entity -> entity.getType() == MessageEntityType.BOT_COMMAND && entity.getOffset().equals(0L))
                .map(entity -> update.getMessage().getText().substring(entity.getLength().intValue()))
                .findFirst()
                .orElse("");
        return client.executeMethod(SetMyDescriptionMethod.builder()
                        .description(parameter)
                        .build())
                .map(ignored -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "setdescription";
    }

    @Override
    public String getDescription() {
        return "Set bot description";
    }
}
