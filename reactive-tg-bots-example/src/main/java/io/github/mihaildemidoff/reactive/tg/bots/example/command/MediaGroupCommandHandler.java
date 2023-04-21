package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputStreamInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.UrlInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.media.InputMediaPhoto;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendMediaGroupMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class MediaGroupCommandHandler implements CommandHandler {

    private static final String PHOTO1 = "sample_image.jpg";
    private static final String PHOTO2 = "sample_image2.jpg";

    @Override
    public Mono<Boolean> handle(final TelegramClient client,
                                final Update update) {
        return Mono.fromCallable(() -> buildMethod(update))
                .flatMap(client::executeMethod)
                .map(ignored -> true)
                .doOnError(error -> log.error("Some error", error))
                .onErrorReturn(false);
    }


    @Override
    public String getCommand() {
        return "mediagroup";
    }

    @Override
    public String getDescription() {
        return "Sends media group to the chat";
    }

    private SendMediaGroupMethod buildMethod(final Update update) {
        final InputMediaPhoto photo1 = InputMediaPhoto.builder()
                .media(InputStreamInputFile.builder()
                        .fileName("photo.jpeg")
                        .inputStream(getFileInputStream(PHOTO1))
                        .mimeType("image/jpeg")
                        .build())
                .build();
        final InputMediaPhoto photo2 = InputMediaPhoto.builder()
                .media(InputStreamInputFile.builder()
                        .fileName("photo2.jpeg")
                        .inputStream(getFileInputStream(PHOTO2))
                        .mimeType("image/jpeg")
                        .build())
                .build();
        final InputMediaPhoto photo3 = InputMediaPhoto.builder()
                .hasSpoiler(true)
                .media(UrlInputFile.builder()
                        .url("https://maven.apache.org/images/maven-logo-black-on-white.png")
                        .build())
                .build();
        return SendMediaGroupMethod.builder()
                .chatId(update.getMessage().getChat().getId().toString())
                .disableNotification(true)
                .protectContent(true)
                .media(List.of(photo1, photo2, photo3))
                .build();
    }

    @SneakyThrows
    private InputStream getFileInputStream(final String filename) {
        return AudioFileCommandHandler.class.getClassLoader().getResourceAsStream(filename);
    }
}
