package io.github.mihaildemidoff.reactive.tg.bots.model.reply;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the
 * default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot.
 * An exception is made for one-time keyboards that are hidden immediately after the user presses a button
 * (see ReplyKeyboardMarkup).
 *
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardremove">ReplyKeyboardRemove</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyKeyboardRemove implements ReplyMarkup {
    /**
     * Requests clients to remove the custom keyboard (user will not be able to summon this keyboard;
     * if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     */
    @NotNull
    @JsonProperty("remove_keyboard")
    private final Boolean removeKeyboard;

    /**
     * <b>Optional.</b><br>
     * Use this parameter if you want to remove the keyboard for specific users only. Targets:
     * <ol>
     * <li> users that are @mentioned in the text of the Message object;</li>
     * <li> if the bot's message is a reply (has reply_to_message_id), sender of the original message.</li>
     * </ol>
     * <p>
     * Example: A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard
     * for that user, while still showing the keyboard with poll options to users who haven't voted yet.
     */
    @JsonProperty("selective")
    private final Boolean selective;
}
