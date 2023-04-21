package io.github.mihaildemidoff.reactive.tg.bots.model.methods.chat.management;


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
 * Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatdescription">setChatDescription</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChatDescriptionMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * New chat description, 0-255 characters
     */
    @Size(max = 255)
    @NotNull
    @JsonProperty("description")
    private final String description;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CHAT_DESCRIPTION;
    }
}
