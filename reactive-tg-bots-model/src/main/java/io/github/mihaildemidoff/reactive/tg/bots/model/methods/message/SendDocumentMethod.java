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
 * Use this method to send general files.
 * On success, the sent {@link Message} is returned.
 * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 *
 * @see <a href="https://core.telegram.org/bots/api#senddocument">sendDocument</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendDocumentMethod implements TypedBotMediaMethodDefinition<Message> {

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
     * File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
     * pass an HTTP URL as a String for Telegram to get a file from the Internet,
     * or upload a new one using multipart/form-data.
     */
    @Valid
    @NotNull
    @JsonProperty("document")
    private final InputFile document;

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
     * Document caption (may also be used when resending documents by file_id), 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * Mode for parsing entities in the document caption. See formatting options for more details.
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
     * Disables automatic server-side content type detection for files uploaded using multipart/form-data
     */
    @JsonProperty("disable_content_type_detection")
    private final Boolean disableContentTypeDetection;

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
        return BotMethod.SEND_DOCUMENT;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Stream.of(document, thumbnail)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
