package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.StreamedInputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.ReplyMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use this method to send audio files, if you want Telegram clients to display them in the music player.
 * Your audio must be in the .MP3 or .M4A format.
 * On success, the sent {@link Message} is returned.
 * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * <p>
 * For sending voice messages, use the sendVoice method instead.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendaudio">sendAudio</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendAudioMethod implements TypedBotMediaMethodDefinition<Message> {

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers
     * (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new
     * one using multipart/form-data.
     */
    @Valid
    @NotNull
    @JsonProperty("audio")
    private final InputFile audio;

    /**
     * Audio caption, 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * Mode for parsing entities in the audio caption. See formatting options for more details.
     */
    @JsonProperty("parse_mode")
    private final ParseMode parseMode;

    /**
     * A JSON-serialized list of special entities that appear in the caption, which can be specified instead of
     * parse_mode
     */
    @Valid
    @JsonProperty("caption_entities")
    private final List<MessageEntity> captionEntities;

    /**
     * Duration of the audio in seconds
     */
    @JsonProperty("duration")
    private final Long duration;

    /**
     * Performer
     */
    @JsonProperty("performer")
    private final String performer;

    /**
     * Track name
     */
    @JsonProperty("title")
    private final String title;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side.
     * The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not
     * exceed 320. Ignored if the file is not uploaded using multipart/form-data.
     * Thumbnails can't be reused and can be only uploaded as a new file, so you can pass
     * “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under
     * &lt;file_attach_name&gt;.
     */
    @Valid
    @JsonProperty("thumbnail")
    private final StreamedInputFile thumbnail;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    private final Boolean disableNotification;

    /**
     * Protects the contents of the forwarded message from forwarding and saving
     */
    @JsonProperty("protect_content")
    private final Boolean protectContent;

    /**
     * If the message is a reply, ID of the original message
     */
    @JsonProperty("reply_to_message_id")
    private final Long replyToMessageId;

    /**
     * Pass True if the message should be sent even if the specified replied-to message is not found
     */
    @JsonProperty("allow_sending_without_reply")
    private final Boolean allowSendingWithoutReply;

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard,
     * instructions to remove reply keyboard or to force a reply from the user.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final ReplyMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_AUDIO;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.of(audio, thumbnail)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
