package io.github.mihaildemidoff.reactive.tg.bots.examples.spring;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.SendMessageMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;

import javax.annotation.PreDestroy;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramBot {

    private final TelegramPoller telegramPoller;
    private final TelegramClient telegramClient;
    private Disposable updatesDisposable;

    @EventListener
    public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        updatesDisposable = telegramPoller.getUpdatesPublisher(List.of())
                .flatMap(update -> {
                    return telegramClient.executeMethod(SendMessageMethod.builder()
                                    .chatId(update.getMessage().getChat().getId().toString())
                                    .text("received update")
                                    .build())
                            .thenReturn(true)
                            .doOnError(error -> log.error("Error during sending response", error))
                            .onErrorReturn(false);
                })
                .subscribe();
    }

    @PreDestroy
    public void onDestroy() {
        if (updatesDisposable != null) {
            updatesDisposable.dispose();
        }
    }

}
