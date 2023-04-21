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
 * Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator
 * in the chat for this to work and must have can_manage_topics administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">editGeneralForumTopic</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditGeneralForumTopicMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel
     * (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * New topic name, 1-128 characters
     */
    @Size(min = 1, max = 128)
    @NotNull
    @JsonProperty("name")
    private final String name;


    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_GENERAL_FORUM_TOPIC;
    }
}
