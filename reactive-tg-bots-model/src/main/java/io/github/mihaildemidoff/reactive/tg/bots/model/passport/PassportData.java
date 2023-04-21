package io.github.mihaildemidoff.reactive.tg.bots.model.passport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Describes Telegram Passport data shared with the bot by the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportdata">PassportData</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportData {

    /**
     * Array with information about documents and other Telegram Passport elements that was shared with the bot
     */
    @Valid
    @NotNull
    @JsonProperty("data")
    private final List<EncryptedPassportElement> data;

    /**
     * Encrypted credentials required to decrypt the data
     */
    @Valid
    @NotNull
    @JsonProperty("credentials")
    private final EncryptedCredentials credentials;
}
