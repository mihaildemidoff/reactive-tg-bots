package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.menu;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu.MenuButton;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to change the bot's menu button in a private chat, or the default menu button.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatmenubutton">setChatMenuButton</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetChatMenuButtonMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
     */
    @JsonProperty("chat_id")
    private final Long chatId;

    /**
     * A JSON-serialized object for the bot's new menu button.
     * Defaults to {@link io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu.MenuButtonDefault}
     */
    @Valid
    @JsonProperty("menu_button")
    private final MenuButton menuButton;


    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_CHAT_MENU_BUTTON;
    }
}
