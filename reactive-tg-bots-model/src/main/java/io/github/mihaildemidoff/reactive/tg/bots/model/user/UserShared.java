package io.github.mihaildemidoff.reactive.tg.bots.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains information about the user whose identifier was shared with the bot using a
 * KeyboardButtonRequestUser button.
 *
 * @see <a href="https://core.telegram.org/bots/api#usershared">UserShared</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserShared {

    /**
     * Identifier of the request
     */
    @NotNull
    @JsonProperty("request_id")
    private final Long requestId;

    /**
     * Identifier of the shared user. This number may have more than 32 significant bits and some programming languages
     * may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit
     * integer or double-precision float type are safe for storing this identifier. The bot may not have access to the
     * user and could be unable to use this identifier, unless the user is already known to the bot by some other means.
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;
}
