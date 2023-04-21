package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntityType;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.SetMyNameMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Mono;

public class SetNameCommandHandler implements CommandHandler {


    @Override
    public Mono<Boolean> handle(final TelegramClient client,
                                final Update update) {
        final String parameter = update.getMessage().getEntities()
                .stream()
                .filter(entity -> entity.getType() == MessageEntityType.BOT_COMMAND && entity.getOffset().equals(0L))
                .map(entity -> update.getMessage().getText().substring(entity.getLength().intValue()))
                .findFirst()
                .orElse("");
        return client.executeMethod(SetMyNameMethod.builder()
                        .name(parameter)
                        .build())
                .map(ignored -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "setname";
    }

    @Override
    public String getDescription() {
        return "Set bot name";
    }
}
