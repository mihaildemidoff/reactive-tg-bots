package io.github.mihaildemidoff.reactive.tg.bots.example;

import io.github.mihaildemidoff.reactive.tg.bots.core.TelegramClient;
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
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

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
    private List<CommandHandler> handlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        example.startExample();
    }

    private void startExample() throws IOException {
        client = initClient();
        initHandlers();
        initCommands();
        startListener();
    }

    private void initHandlers() {
        handlers.add(new GetInfoCommandHandler());
        handlers.add(new SetNameCommandHandler());
        handlers.add(new SetDescriptionCommandHandler());
        handlers.add(new SetShortDescriptionCommandHandler());
        handlers.add(new PhotoUrlCommandHandler());
        handlers.add(new PhotoFileCommandHandler());
        handlers.add(new VoiceUrlCommandHandler());
        handlers.add(new AudioFileCommandHandler());
        handlers.add(new DocumentFileCommandHandler());
        handlers.add(new MediaGroupCommandHandler());
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
        client.getUpdatesPublisher(List.of())
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
                                        .handle(client, update)
                                        .doOnError(error -> log.error("Error occurred during handler invocation"))
                                        .onErrorReturn(false);
                            }
                        }
                    }
                    return Mono.just(true);
                })
                .subscribe();
    }

    private TelegramClient initClient() throws IOException {
        try (InputStream input = ComplexExample.class.getClassLoader().getResourceAsStream("config.properties")) {
            final Properties prop = new Properties();
            prop.load(input);
            final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            final TelegramBotProperties tgProperties = new TelegramBotProperties(prop.getProperty("telegram.bot.token"), Duration.ofSeconds(10), Duration.ofSeconds(50), prop.getProperty("telegram.bot.url"));
            return new TelegramClient(tgProperties, HttpClientBuilder.defaultHttpClient(Duration.ofSeconds(10)), new ValidatorValidationService(factory.getValidator()));
        }
    }

    private <RESPONSE> Mono<RESPONSE> sendRequest(final BaseBotMethodDefinition<RESPONSE> method) {
        return client.executeMethod(method);
    }

}
