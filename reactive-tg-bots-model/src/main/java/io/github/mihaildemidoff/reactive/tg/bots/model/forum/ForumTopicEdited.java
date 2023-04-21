package io.github.mihaildemidoff.reactive.tg.bots.model.forum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a service message about an edited forum topic
 *
 * @see <a href="https://core.telegram.org/bots/api#forumtopicedited">ForumTopicEdited</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForumTopicEdited {

    /**
     * <b>Optional.</b><br>
     * New name of the topic, if it was edited
     */
    @JsonProperty("name")
    private final String name;

    /**
     * <b>Optional.</b><br>
     * New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string if the
     * icon was removed
     */
    @JsonProperty("icon_custom_emoji_id")
    private final String iconCustomEmojiId;

}
