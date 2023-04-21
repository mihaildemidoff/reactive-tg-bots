package io.github.mihaildemidoff.reactive.tg.bots.model.reply;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if
 * the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create
 * user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 *
 * @see <a href="https://core.telegram.org/bots/api#forcereply">ForceReply</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForceReply implements ReplyMarkup {

    /**
     * Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
     */
    @NotNull
    @JsonProperty("force_reply")
    private final Boolean forceReply;

    /**
     * <b>Optional.</b><br>
     * The placeholder to be shown in the input field when the reply is active; 1-64 characters
     */
    @Size(min = 1, max = 64)
    @JsonProperty("input_field_placeholder")
    private final String inputFieldPlaceholder;

    /**
     * <b>Optional.</b><br>
     * Use this parameter if you want to force reply from specific users only. Targets:
     * <ol>
     *     <li>users that are @mentioned in the text of the Message object;</li>
     *     <li>if the bot's message is a reply (has reply_to_message_id), sender of the original message.</li>
     * </ol>
     */
    @JsonProperty("selective")
    private final Boolean selective;

}
