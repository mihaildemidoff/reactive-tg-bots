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
 * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatadministratorcustomtitle">setChatAdministratorCustomTitle</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChatAdministratorCustomTitleMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target group or username of the target supergroup or channel (in the
     * format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier of the target user
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * New custom title for the administrator; 0-16 characters, emoji are not allowed
     */
    @Size(max = 16)
    @NotNull
    @JsonProperty("custom_title")
    private final String customTitle;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CHAT_ADMINISTRATOR_CUSTOM_TITLE;
    }
}
