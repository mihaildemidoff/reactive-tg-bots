package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.forum;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the
 * chat for this to work and must have can_manage_topics administrator rights, unless it is the creator of the topic.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#editforumtopic">editForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditForumTopicMethod implements BooleanBotMethodDefinition {

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

    /**
     * New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
     */
    @Size(max = 128)
    @JsonProperty("name")
    private final String name;

    /**
     * New unique identifier of the custom emoji shown as the topic icon. Use getForumTopicIconStickers to get all
     * allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon
     * will be kept
     */
    @JsonProperty("icon_custom_emoji_id")
    private final String iconCustomEmojiId;


    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_FORUM_TOPIC;
    }
}
