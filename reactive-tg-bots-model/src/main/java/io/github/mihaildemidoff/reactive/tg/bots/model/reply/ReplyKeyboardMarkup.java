package io.github.mihaildemidoff.reactive.tg.bots.model.reply;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.keyboard.KeyboardButton;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details and examples).
 *
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyKeyboardMarkup implements ReplyMarkup {

    /**
     * Array of button rows, each represented by an Array of KeyboardButton objects
     */
    @Valid
    @NotNull
    @JsonProperty("keyboard")
    private final List<List<KeyboardButton>> keyboard;

    /**
     * <b>Optional.</b><br>
     * Requests clients to always show the keyboard when the regular keyboard is hidden.
     * Defaults to false, in which case the custom keyboard can be hidden and opened with a keyboard icon.
     */
    @JsonProperty("is_persistent")
    private final Boolean isPersistent;

    /**
     * <b>Optional.</b><br>
     * Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller
     * if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the
     * same height as the app's standard keyboard.
     */
    @JsonProperty("resize_keyboard")
    private final Boolean resizeKeyboard;

    /**
     * <b>Optional.</b><br>
     * Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available,
     * but clients will automatically display the usual letter-keyboard in the chat - the user can press a special
     * button in the input field to see the custom keyboard again. Defaults to false.
     */
    @JsonProperty("one_time_keyboard")
    private final Boolean oneTimeKeyboard;

    /**
     * <b>Optional.</b><br>
     * The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
     */
    @Size(min = 1, max = 64)
    @JsonProperty("input_field_placeholder")
    private final String inputFieldPlaceholder;

    /**
     * <b>Optional.</b><br>
     * Use this parameter if you want to show the keyboard to specific users only. Targets:
     * <ol>
     * <li>users that are @mentioned in the text of the Message object;
     * </li>
     * <li>if the bot's message is a reply (has reply_to_message_id), sender of the original message.</li>
     * </ol>
     * <p>
     * Example: A user requests to change the bot's language, bot replies to the request with a keyboard to select the
     * new language. Other users in the group don't see the keyboard.
     */
    @JsonProperty("selective")
    private final Boolean selective;
}
