package io.github.mihaildemidoff.reactive.tg.bots.model.reply.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object defines the criteria used to request a suitable user.
 * The identifier of the selected user will be shared with the bot when the corresponding button is pressed.
 *
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonrequestuser">KeyboardButtonRequestUser</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardButtonRequestUser {

    /**
     * Signed 32-bit identifier of the request, which will be received back in the UserShared object.
     * Must be unique within the message
     */
    @NotNull
    @JsonProperty("request_id")
    private final Long requestId;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a bot, pass False to request a regular user.
     * If not specified, no additional restrictions are applied.
     */
    @JsonProperty("user_is_bot")
    private final Boolean userIsBot;

    /**
     * <b>Optional.</b><br>
     * Pass True to request a premium user, pass False to request a non-premium user.
     * If not specified, no additional restrictions are applied.
     */
    @JsonProperty("user_is_premium")
    private final Boolean userIsPremium;

}
