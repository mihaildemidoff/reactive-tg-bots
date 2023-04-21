package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.forum;


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
 * Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat
 * for this to work and must have the can_pin_messages administrator right in the supergroup.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unpinallforumtopicmessages">unpinAllForumTopicMessages</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnpinAllForumTopicMessagesMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier for the target message thread of the forum topic
     */
    @NotNull
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;


    @Override
    public BotMethod getMethod() {
        return BotMethod.UNPIN_ALL_FORUM_TOPIC_MESSAGES;
    }
}
