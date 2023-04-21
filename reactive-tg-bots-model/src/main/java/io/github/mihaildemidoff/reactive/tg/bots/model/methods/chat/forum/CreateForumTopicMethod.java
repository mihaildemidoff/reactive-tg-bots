package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.forum;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.forum.ForumTopic;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to create a topic in a forum supergroup chat.
 * The bot must be an administrator in the chat for this to work and must have the can_manage_topics administrator
 * rights.
 * Returns information about the created topic as a {@link ForumTopic} object.
 *
 * @see <a href="https://core.telegram.org/bots/api#createforumtopic">createForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateForumTopicMethod implements TypedBotMethodDefinition<ForumTopic> {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Topic name, 1-128 characters
     */
    @Size(min = 1, max = 128)
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E),
     * 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F)
     */
    @JsonProperty("icon_color")
    // TODO: add validation
    private final Long iconColor;

    /**
     * Unique identifier of the custom emoji shown as the topic icon. Use getForumTopicIconStickers to get all allowed
     * custom emoji identifiers.
     */
    @JsonProperty("icon_custom_emoji_id")
    private final String iconCustomEmojiId;

    @Override
    public TypeReference<GenericBotApiResponse<ForumTopic>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.CREATE_FORUM_TOPIC;
    }
}
