package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.pin;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat,
 * the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator
 * right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unpinchatmessage">unpinChatMessage</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnpinChatMessageMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be
     * unpinned.
     */
    @NotNull
    @JsonProperty("message_id")
    private final Long messageId;


    @Override
    public BotMethod getMethod() {
        return BotMethod.UNPIN_CHAT_MESSAGE;
    }
}
