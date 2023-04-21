package io.github.mihaildemidoff.reactive.tg.bots.model.passport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Describes data required for decrypting and authenticating EncryptedPassportElement.
 * See the Telegram Passport Documentation for a complete description of the data decryption and authentication
 * processes.
 *
 * @see <a href="https://core.telegram.org/bots/api#encryptedcredentials">EncryptedCredentials</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncryptedCredentials {

    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for
     * EncryptedPassportElement decryption and authentication
     */
    @NotNull
    @JsonProperty("data")
    private final String data;

    /**
     * Base64-encoded data hash for data authentication
     */
    @NotNull
    @JsonProperty("hash")
    private final String hash;

    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    @NotNull
    @JsonProperty("secret")
    private final String secret;

}
