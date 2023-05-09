package io.github.mihaildemidoff.reactive.tg.bots.core.client.api;

import io.github.mihaildemidoff.reactive.tg.bots.core.properties.api.TelegramBotProperties;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.File;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.time.Duration;

/**
 * Telegram client with base integration methods.
 */
public interface TelegramClient {

    /**
     * Execute telegram method.
     *
     * @param method     method to execute
     * @param <RESPONSE> expected response
     * @return Mono with deserialized response or Mono.error.
     * See {@link io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException} for all possible errors.
     * @see io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException
     * @see TelegramBotProperties#getTimeout()
     */
    <RESPONSE> Mono<RESPONSE> executeMethod(BaseBotMethodDefinition<RESPONSE> method);

    /**
     * Execute telegram method.
     *
     * @param method     method to execute
     * @param timeout    connection timeout
     * @param <RESPONSE> expected response
     * @return Mono with deserialized response or Mono.error.
     * See {@link io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException} for all possible errors.
     * @see io.github.mihaildemidoff.reactive.tg.bots.core.exception.TelegramBotClientException
     * @see TelegramBotProperties#getTimeout()
     */
    <RESPONSE> Mono<RESPONSE> executeMethod(BaseBotMethodDefinition<RESPONSE> method, Duration timeout);

    /**
     * Downloads file from telegram server.
     *
     * @param file file to download
     * @return file as Flux of ByteBuffer
     */
    Flux<ByteBuffer> getFileAsByteBuffer(File file);

    /**
     * Downloads file from telegram server.
     *
     * @param fileId file to download
     * @return file as Flux of ByteBuffer
     */
    Flux<ByteBuffer> getFileAsByteBuffer(String fileId);

    /**
     * Downloads file from telegram server.
     *
     * @param file file to download
     * @return file as InputStream
     */
    Mono<InputStream> getFileAsInputStream(File file);

    /**
     * Downloads file from telegram server.
     *
     * @param fileId file to download
     * @return file as InputStream
     */
    Mono<InputStream> getFileAsInputStream(String fileId);


}
