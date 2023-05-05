package io.github.mihaildemidoff.reactive.tg.bots.example;

import io.github.mihaildemidoff.reactive.tg.bots.core.client.DefaultTelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.DefaultTelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramClient;
import io.github.mihaildemidoff.reactive.tg.bots.core.client.api.TelegramPoller;
import io.github.mihaildemidoff.reactive.tg.bots.core.http.HttpClientBuilder;
import io.github.mihaildemidoff.reactive.tg.bots.core.properties.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.core.validation.ValidatorValidationService;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.AudioFileCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.CommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.DocumentFileCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.GetInfoCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.MediaGroupCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.PhotoFileCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.PhotoUrlCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.SetDescriptionCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.SetNameCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.SetShortDescriptionCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.example.command.VoiceUrlCommandHandler;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommand;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.command.BotCommandScopeDefault;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntityType;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.DeleteMyCommandsMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.GetMyCommandsMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.SetMyCommandsMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.update.Update;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
public class ComplexExample {

    private static final ComplexExample example = new ComplexExample();

    private TelegramClient client;
    private TelegramPoller poller;
    private List<CommandHandler> handlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        example.startExample();
    }

    private void startExample() throws IOException {
        final TelegramBotProperties tgProperties = initProperties();
        client = initClient(tgProperties);
        poller = new DefaultTelegramPoller(client, tgProperties);
        initHandlers();
        initCommands();
        startListener();
    }

    private void initHandlers() {
        handlers.add(new GetInfoCommandHandler(client));
        handlers.add(new SetNameCommandHandler(client));
        handlers.add(new SetDescriptionCommandHandler(client));
        handlers.add(new SetShortDescriptionCommandHandler(client));
        handlers.add(new PhotoUrlCommandHandler(client));
        handlers.add(new PhotoFileCommandHandler(client));
        handlers.add(new VoiceUrlCommandHandler(client));
        handlers.add(new AudioFileCommandHandler(client));
        handlers.add(new DocumentFileCommandHandler(client));
        handlers.add(new MediaGroupCommandHandler(client));
    }

    private void initCommands() {
        final GetMyCommandsMethod getMyCommandsMethod = GetMyCommandsMethod.builder().build();
        sendRequest(getMyCommandsMethod)
                .flatMap(commands -> {
                    if (!commands.isEmpty()) {
                        return sendRequest(DeleteMyCommandsMethod.builder().build());
                    }
                    return Mono.just(true);
                })
                .flatMap(skippedResult -> {

                    final SetMyCommandsMethod setMyCommandsMethod = SetMyCommandsMethod.builder()
                            .commands(handlers.stream()
                                    .map(handler -> BotCommand.builder()
                                            .command(handler.getCommand())
                                            .description(handler.getDescription())
                                            .build())
                                    .collect(Collectors.toList()))
                            .scope(BotCommandScopeDefault.builder().build())
                            .build();
                    return sendRequest(setMyCommandsMethod);
                })
                .subscribe();
    }

    private void startListener() {
        poller.getUpdatesPublisher(List.of())
                .flatMap(update -> {
                    log.info("Got update {}", update);
                    if (update.getMessage() != null
                            && update.getMessage().getEntities() != null) {
                        final Optional<MessageEntity> commandMessage = update.getMessage().getEntities().stream().filter(entity -> entity.getType() == MessageEntityType.BOT_COMMAND
                                        && entity.getOffset().equals(0L))
                                .findFirst();
                        if (commandMessage.isPresent()) {
                            final String messageCommand = update.getMessage().getText().substring(commandMessage.get().getOffset().intValue() + 1, commandMessage.get().getOffset().intValue() + commandMessage.get().getLength().intValue());
                            final Optional<CommandHandler> foundHandler = handlers.stream().filter(handler -> handler.getCommand().equalsIgnoreCase(messageCommand))
                                    .findFirst();
                            if (foundHandler.isPresent()) {
                                return foundHandler.get()
                                        .handle(update)
                                        .doOnError(error -> log.error("Error occurred during handler invocation"))
                                        .onErrorReturn(false);
                            }
                        }
                    }
                    if (update.getMessage().getPhoto() != null && !update.getMessage().getPhoto().isEmpty()) {
                        return downloadFiles(update);
                    }
                    return Mono.just(true);
                })
                .subscribe();
    }

    private Mono<Boolean> downloadFiles(final Update update) {
        return Flux.fromIterable(update.getMessage().getPhoto())
                .flatMap(file -> client.getFileAsInputStream(file.getFileId())
                        .flatMap(inputStream -> {
                            try {
                                IOUtils.copy(inputStream, new FileOutputStream("/Users/mihaildemidoff/temp/" + file.getFileUniqueId() + ".jpg"));
                                return Mono.just(true);
                            } catch (IOException e) {
                                log.error("Copy error", e);
                                throw new RuntimeException(e);
                            }
                        }))
                .doOnError(error -> log.error("Error during downloading file", error))
                .onErrorReturn(false)
                .then(Mono.just(true));
    }

    private TelegramClient initClient(final TelegramBotProperties properties) throws IOException {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return new DefaultTelegramClient(properties, HttpClientBuilder.defaultHttpClient(properties.getBaseUrl(), properties.getTimeout()),
                new ValidatorValidationService(factory.getValidator()));
    }

    private TelegramBotProperties initProperties() throws IOException {
        try (InputStream input = ComplexExample.class.getClassLoader().getResourceAsStream("config.properties")) {
            final Properties prop = new Properties();
            prop.load(input);
            return new TelegramBotProperties(prop.getProperty("telegram.bot.token"), Duration.ofSeconds(10), Duration.ofSeconds(50), prop.getProperty("telegram.bot.url"));
        }
    }

    private <RESPONSE> Mono<RESPONSE> sendRequest(final BaseBotMethodDefinition<RESPONSE> method) {
        return client.executeMethod(method);
    }

}
