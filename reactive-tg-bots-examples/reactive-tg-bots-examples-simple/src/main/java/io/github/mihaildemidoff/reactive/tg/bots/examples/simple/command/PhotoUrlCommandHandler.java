package io.github.mihaildemidoff.reactive.tg.bots.examples.simple.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.UrlInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendPhotoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PhotoUrlCommandHandler implements CommandHandler {

    private final TelegramClient client;

    @Override
    public Mono<Boolean> handle(final Update update) {
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
