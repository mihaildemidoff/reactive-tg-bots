package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputStreamInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendPhotoMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

import java.io.InputStream;

public class PhotoFileCommandHandler implements CommandHandler {


    private static final String PHOTO = "sample_image.jpg";

    @Override
    public Mono<Boolean> handle(final TelegramClient client,
                                final Update update) {
        return Mono.fromCallable(() -> SendPhotoMethod.builder()
                        .chatId(update.getMessage().getChat().getId().toString())
                        .photo(InputStreamInputFile.builder()
                                .fileName("photo.jpeg")
                                .inputStream(getFileInputStream())
                                .mimeType("image/jpeg")
                                .build())
                        .build())
                .flatMap(client::executeMethod)
                .map(ignored -> true)
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "photofile";
    }

    @Override
    public String getDescription() {
        return "Sends photo file to the chat";
    }

    @SneakyThrows
    private InputStream getFileInputStream() {
        return AudioFileCommandHandler.class.getClassLoader().getResourceAsStream(PHOTO);
    }
}
