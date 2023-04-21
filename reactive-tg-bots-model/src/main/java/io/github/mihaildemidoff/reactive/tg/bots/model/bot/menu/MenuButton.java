package io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;

/**
 * This object describes the bot's menu button in a private chat.
 * <p>
 * If a menu button other than MenuButtonDefault is set for a private chat, then it is applied in the chat.
 * Otherwise the default menu button is applied. By default, the menu button opens the list of bot commands.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubutton">MenuButton</a>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MenuButtonCommands.class, name = "commands"),
        @JsonSubTypes.Type(value = MenuButtonDefault.class, name = "default"),
        @JsonSubTypes.Type(value = MenuButtonWebApp.class, name = "web_app")
})
public interface MenuButton extends BotApiResponse {

    /**
     * Type of menu button
     *
     * @return type of menu button
     */
    MenuButtonType getType();

}
