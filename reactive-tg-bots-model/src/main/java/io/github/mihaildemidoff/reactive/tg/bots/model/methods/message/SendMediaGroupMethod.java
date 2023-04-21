package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMediaMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.media.InputMedia;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.ReplyMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Use this method to send a group of photos, videos, documents or audios as an album.
 * Documents and audio files can be only grouped in an album with messages of the same type.
 * On success, an array of {@link Message} that were sent is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendmediagroup">sendMediaGroup</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMediaGroupMethod implements ListBotMediaMethodDefinition<Message> {

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
     * A JSON-serialized array describing messages to be sent, must include 2-10 items
     */
    @Valid
    @Size(min = 2, max = 10)
    @NotEmpty
    @NotNull
    @JsonProperty("media")
    private final List<InputMedia> media;

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
    @JsonProperty("reply_markup")
    private final ReplyMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<List<Message>>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_MEDIA_GROUP;
    }

    @Override
    public List<InputFile> getAllInputFiles() {
        return Optional.ofNullable(media)
                .orElse(List.of())
                .stream()
                .flatMap(singleMedia -> Optional
                        .ofNullable(singleMedia.getInputFiles())
                        .orElse(List.of())
                        .stream())
                .collect(Collectors.toList());

    }
}
