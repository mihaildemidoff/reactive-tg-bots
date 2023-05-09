package io.github.mihaildemidoff.reactive.tg.bots.examples.simple.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputStreamInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendAudioMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class AudioFileCommandHandler implements CommandHandler {

    private final TelegramClient client;

    private static final String MP3 = "sample_audio.mp3";
    private static final String THUMBNAIL = "sample_image2.jpg";

    @Override
    public Mono<Boolean> handle(final Update update) {
        return Mono.fromCallable(() -> SendAudioMethod.builder()
                        .chatId(update.getMessage().getChat().getId().toString())
                        .audio(InputStreamInputFile.builder()
                                .fileName("sample.mp3")
                                .inputStream(getFileInputStream(MP3))
                                .mimeType("audio/mpeg")
                                .build())
                        .thumbnail(InputStreamInputFile.builder()
                                .fileName("sample.jpeg")
                                .inputStream(getFileInputStream(THUMBNAIL))
                                .mimeType("image/jpeg")
                                .build())
                        .build()
                )
                .flatMap(client::executeMethod)
                .map(ignored -> true)
                .doOnError(error -> log.error("Some error", error))
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "audiofile";
    }

    @Override
    public String getDescription() {
        return "Sends audio to the chat";
    }


    @SneakyThrows
    private InputStream getFileInputStream(final String filename) {
        return AudioFileCommandHandler.class.getClassLoader().getResourceAsStream(filename);
    }
}
