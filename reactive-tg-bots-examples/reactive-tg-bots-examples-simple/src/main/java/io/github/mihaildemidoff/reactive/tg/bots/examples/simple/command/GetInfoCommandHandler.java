package io.github.mihaildemidoff.reactive.tg.bots.examples.simple.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMeMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMyDescriptionMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMyNameMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMyShortDescriptionMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.rights.GetMyDefaultAdministratorRightsMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendMessageMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetInfoCommandHandler implements CommandHandler {

    private final TelegramClient client;

    @Override
    public Mono<Boolean> handle(final Update update) {
        final GetMeMethod getMeMethod = GetMeMethod.builder().build();
        final GetMyNameMethod getMyNameMethod = GetMyNameMethod.builder()
                .build();
        final GetMyDescriptionMethod getMyDescriptionMethod = GetMyDescriptionMethod.builder()
                .build();
        final GetMyShortDescriptionMethod getMyShortDescriptionMethod = GetMyShortDescriptionMethod.builder()
                .build();
        final GetMyDefaultAdministratorRightsMethod getMyDefaultAdministratorRightsMethod = GetMyDefaultAdministratorRightsMethod
                .builder().build();
        return Mono.zip(client.executeMethod(getMeMethod), client.executeMethod(getMyNameMethod), client.executeMethod(getMyDescriptionMethod), client.executeMethod(getMyShortDescriptionMethod), client.executeMethod(getMyDefaultAdministratorRightsMethod))
                .flatMap(t -> client.executeMethod(SendMessageMethod.builder()
                        .chatId(String.valueOf(update.getMessage().getFrom().getId()))
                        .text(String.format("Username: %s%nfirstName: %s%nName: %s%nDescription: %s%nShort Description: %s%nRights: %s", t.getT1().getUsername(), t.getT1().getFirstName(), t.getT2().getName(), t.getT3().getDescription(), t.getT4().getShortDescription(), t.getT5()))
                        .build()))
                .map(result -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "getinfo";
    }

    @Override
    public String getDescription() {
        return "Get base info about bot";
    }
}
