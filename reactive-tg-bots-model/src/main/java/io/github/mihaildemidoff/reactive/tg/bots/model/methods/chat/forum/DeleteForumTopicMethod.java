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
 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat.
 * The bot must be an administrator in the chat for this to work and must have the can_delete_messages administrator
 * rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deleteforumtopic">deleteForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteForumTopicMethod implements BooleanBotMethodDefinition {

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
        return BotMethod.DELETE_FORUM_TOPIC;
    }
}
