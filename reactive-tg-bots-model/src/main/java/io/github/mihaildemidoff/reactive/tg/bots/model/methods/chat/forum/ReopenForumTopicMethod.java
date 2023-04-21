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
 * Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat
 * for this to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#reopenforumtopic">reopenForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReopenForumTopicMethod implements BooleanBotMethodDefinition {

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
        return BotMethod.REOPEN_FORUM_TOPIC;
    }
}
