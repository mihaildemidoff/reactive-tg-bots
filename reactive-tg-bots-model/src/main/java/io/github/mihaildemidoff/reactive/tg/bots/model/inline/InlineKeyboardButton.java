package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.games.CallbackGame;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">InlineKeyboardButton</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineKeyboardButton {

    /**
     * Label text on the button
     */
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * <b>Optional.</b><br>
     * HTTP or tg:// URL to be opened when the button is pressed.
     * Links tg://user?id=&lt;user_id&gt; can be used to mention a user by their ID without using a username, if this is
     * allowed by their privacy settings.
     */
    @JsonProperty("url")
    private final String url;

    /**
     * <b>Optional.</b><br>
     * Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    @JsonProperty("callback_data")
    private final String callbackData;

    /**
     * <b>Optional.</b><br>
     * Description of the Web App that will be launched when the user presses the button.
     * The Web App will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     * Available only in private chats between a user and the bot.
     */
    @Valid
    @JsonProperty("web_app")
    private final WebAppInfo webApp;

    /**
     * <b>Optional.</b><br>
     * An HTTPS URL used to automatically authorize the user.
     * Can be used as a replacement for the Telegram Login Widget.
     */
    @Valid
    @JsonProperty("login_url")
    private final LoginUrl loginUrl;

    /**
     * <b>Optional.</b><br>
     * If set, pressing the button will prompt the user to select one of their chats, open that chat and
     * insert the bot's username and the specified inline query in the input field.
     * May be empty, in which case just the bot's username will be inserted.
     * <p>
     * <b>Note:</b> This offers an easy way for users to start using your bot in inline mode when they are currently in
     * a private chat with it. Especially useful when combined with switch_pm… actions - in this case the user will be
     * automatically returned to the chat they switched from, skipping the chat selection screen.
     */
    @JsonProperty("switch_inline_query")
    private final String switchInlineQuery;

    /**
     * <b>Optional.</b><br>
     * If set, pressing the button will insert the bot's username and the specified inline query in the
     * current chat's input field. May be empty, in which case only the bot's username will be inserted.
     * <p>
     * This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting
     * something from multiple options.
     */
    @JsonProperty("switch_inline_query_current_chat")
    private final String switchInlineQueryCurrentChat;

    /**
     * <b>Optional.</b><br>
     * If set, pressing the button will prompt the user to select one of their chats of the specified type,
     * open that chat and insert the bot's username and the specified inline query in the input field
     */
    @Valid
    @JsonProperty("switch_inline_query_chosen_chat")
    private final SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    /**
     * <b>Optional.</b><br>
     * Description of the game that will be launched when the user presses the button.
     *
     * <b>NOTE:</b> This type of button must always be the first button in the first row.
     */
    @Valid
    @JsonProperty("callback_game")
    private final CallbackGame callbackGame;

    /**
     * <b>Optional.</b><br>
     * Specify True, to send a Pay button.
     *
     * <b>NOTE:</b> This type of button must always be the first button in the first row and can only be used in invoice
     * messages.
     */
    @NotNull
    @JsonProperty("pay")
    private final Boolean pay;

}
