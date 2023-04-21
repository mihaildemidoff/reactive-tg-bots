package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.media;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message
 * album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a
 * photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously
 * uploaded file via its file_id or specify a URL. On success edited {@link Message} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditMessageMediaMethod extends AbstractEditMessageMediaMethod<Message> {

    /**
     * Unique identifier for the target chat or username of the target
     * channel (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Identifier of the message to edit
     */
    @NotNull
    @JsonProperty("message_id")
    private final Long messageId;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }
}
