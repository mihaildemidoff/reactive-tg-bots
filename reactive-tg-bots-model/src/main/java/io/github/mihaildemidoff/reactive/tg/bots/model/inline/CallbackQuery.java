package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard.
 * If the button that originated the query was attached to a message sent by the bot, the field message will be present.
 * If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be
 * present.
 * Exactly one of the fields data or game_short_name will be present.
 * <b>NOTE:</b> After the user presses a callback button, Telegram clients will display a progress bar until you call
 * answerCallbackQuery.
 * It is, therefore, necessary to react by calling answerCallbackQuery even if no notification to the user is needed
 * (e.g., without specifying any of the optional parameters).
 *
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">CallbackQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackQuery {
    /**
     * Unique identifier for this query
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * Sender
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * <b>Optional.</b><br>
     * Message with the callback button that originated the query.
     * Note that message content and message date will not be available if the message is too old
     */
    @Valid
    @JsonProperty("message")
    private final Message message;

    /**
     * <b>Optional.</b><br>
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent.
     * Useful for high scores in games.
     */
    @NotNull
    @JsonProperty("chat_instance")
    private final String chatInstance;

    /**
     * <b>Optional.</b><br>
     * Data associated with the callback button.
     * Be aware that the message originated the query can contain no callback buttons with this data.
     */
    @JsonProperty("data")
    private final String data;

    /**
     * <b>Optional.</b><br>
     * Short name of a Game to be returned, serves as the unique identifier for the game
     */
    @JsonProperty("game_short_name")
    private final String gameShortName;

}
