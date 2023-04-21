package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.caption;


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
 * Use this method to edit captions of messages. On success the edited {@link Message} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">editMessageCaption</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditMessageCaptionMethod extends AbstractEditMessageCaptionMethod<Message> {

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
