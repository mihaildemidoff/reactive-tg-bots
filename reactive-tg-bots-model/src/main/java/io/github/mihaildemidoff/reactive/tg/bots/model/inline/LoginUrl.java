package io.github.mihaildemidoff.reactive.tg.bots.model.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a parameter of the inline keyboard button used to automatically authorize a user.
 * Serves as a great replacement for the Telegram Login Widget when the user is coming from Telegram.
 *
 * @see <a href="https://core.telegram.org/bots/api#loginurl">LoginUrl</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUrl {

    /**
     * An HTTPS URL to be opened with user authorization data added to the query string when the button is pressed.
     * If the user refuses to provide authorization data, the original URL without information about the user will be
     * opened. The data added is the same as described in Receiving authorization data.
     * <p>
     * <b>NOTE:</b> You must always check the hash of the received data to verify the authentication and the integrity
     * of the data as described in Checking authorization.
     */
    @NotNull
    @JsonProperty("url")
    private final String url;

    /**
     * <b>Optional.</b><br>
     * New text of the button in forwarded messages.
     */
    @JsonProperty("forward_text")
    private final String forwardText;

    /**
     * <b>Optional.</b><br>
     * Username of a bot, which will be used for user authorization. See Setting up a bot for more details.
     * If not specified, the current bot's username will be assumed.
     * The url's domain must be the same as the domain linked with the bot. See Linking your domain to the bot for more
     * details.
     */
    @NotNull
    @JsonProperty("bot_username")
    private final String botUsername;

    /**
     * <b>Optional.</b><br>
     * Pass True to request the permission for your bot to send messages to the user.
     */
    @NotNull
    @JsonProperty("request_write_access")
    private final Boolean requestWriteAccess;

}
