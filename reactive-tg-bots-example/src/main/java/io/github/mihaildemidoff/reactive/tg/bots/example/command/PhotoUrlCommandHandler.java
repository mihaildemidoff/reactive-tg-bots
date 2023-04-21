package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.UrlInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendPhotoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import reactor.core.publisher.Mono;

public class PhotoUrlCommandHandler implements CommandHandler {


    @Override
    public Mono<Boolean> handle(final TelegramClient client,
                                final Update update) {
        return client.executeMethod(SendPhotoMethod.builder()
                        .chatId(update.getMessage().getChat().getId().toString())
                        .photo(UrlInputFile.builder()
                                .url("https://maven.apache.org/images/maven-logo-black-on-white.png")
                                .build())
                        .build())
                .map(ignored -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "photourl";
    }

    @Override
    public String getDescription() {
        return "Sends photo by url to the chat";
    }
}
