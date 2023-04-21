package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.FileIdInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendVoiceMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Mono;

public class VoiceUrlCommandHandler implements CommandHandler {


    @Override
    public Mono<Boolean> handle(final TelegramClient client,
                                final Update update) {
        return client.executeMethod(SendVoiceMethod.builder()
                        .chatId(update.getMessage().getChat().getId().toString())
                        .voice(FileIdInputFile.builder()
                                .fileId("AwACAgIAAxkBAAOdZE5vWX8dUznUqBdJSosegyqVhWMAArMpAALxjXFKnlDBdN-VhLAvBA")
                                .build())
                        .build())
                .map(ignored -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "voicefileid";
    }

    @Override
    public String getDescription() {
        return "Sends voice by fileid to the chat";
    }
}
