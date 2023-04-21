package io.github.mihaildemidoff.reactive.tg.bots.model.methods.bot.menu;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu.MenuButton;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to get the current value of the bot's menu button in a private chat, or the default menu button.
 * Returns {@link MenuButton} on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatmenubutton">getChatMenuButton</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChatMenuButtonMethod implements TypedBotMethodDefinition<MenuButton> {

    /**
     * Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
     */
    @JsonProperty("chat_id")
    private final Long chatId;


    @Override
    public TypeReference<GenericBotApiResponse<MenuButton>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_CHAT_MENU_BUTTON;
    }
}
