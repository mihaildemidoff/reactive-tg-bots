package io.github.mihaildemidoff.reactive.tg.bots.example.command;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputStreamInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendDocumentMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class DocumentFileCommandHandler implements CommandHandler {

    private final TelegramClient client;
    private static final String DOCUMENT = "sample_document.txt";
    private static final String THUMBNAIL = "sample_image2.jpg";

    @Override
    public Mono<Boolean> handle(final Update update) {
        return Mono.fromCallable(() -> SendDocumentMethod.builder()
                        .chatId(update.getMessage().getChat().getId().toString())
                        .document(InputStreamInputFile.builder()
                                .fileName("sample.txt")
                                .inputStream(getFileInputStream(DOCUMENT))
                                .build())
                        .thumbnail(InputStreamInputFile.builder()
                                .fileName("sample.jpeg")
                                .inputStream(getFileInputStream(THUMBNAIL))
                                .mimeType("image/jpeg")
                                .build())
                        .build())
                .flatMap(client::executeMethod)
                .map(ignored -> true)
                .doOnError(error -> log.error("Some error", error))
                .onErrorReturn(false);
    }

    @Override
    public String getCommand() {
        return "documentfile";
    }

    @Override
    public String getDescription() {
        return "Sends document to the chat";
    }

    @SneakyThrows
    private InputStream getFileInputStream(final String filename) {
        return AudioFileCommandHandler.class.getClassLoader().getResourceAsStream(filename);
    }
}
