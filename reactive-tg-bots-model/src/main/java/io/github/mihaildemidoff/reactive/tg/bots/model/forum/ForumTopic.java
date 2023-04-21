package io.github.mihaildemidoff.reactive.tg.bots.model.forum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a forum topic.
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopic">ForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForumTopic implements BotApiResponse {

    /**
     * Unique identifier of the forum topic
     */
    @NotNull
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Name of the topic
     */
    @NotNull
    @JsonProperty("name")
    private final String name;

    /**
     * Color of the topic icon in RGB format
     */
    @NotNull
    @JsonProperty("icon_color")
    private final Long iconColor;

    /**
     * <b>Optional.</b><br>
     * Unique identifier of the custom emoji shown as the topic icon
     */
    @JsonProperty("icon_custom_emoji_id")
    private final String iconCustomEmojiId;

}
