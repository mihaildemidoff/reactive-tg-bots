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
 * Describes documents or other Telegram Passport elements shared with the bot by the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#encryptedpassportelement">EncryptedPassportElement</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncryptedPassportElement {
    /**
     * Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”,
     * “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”,
     * “temporary_registration”, “phone_number”, “email”.
     */
    @NotNull
    @JsonProperty("type")
    private final EncryptedPassportElementType type;

    /**
     * <b>Optional.</b><br>
     * Base64-encoded encrypted Telegram Passport element data provided by the user, available for
     * “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types.
     * Can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @JsonProperty("data")
    private final String data;

    /**
     * <b>Optional.</b><br>
     * User's verified phone number, available only for “phone_number” type
     */
    @JsonProperty("phone_number")
    private final String phoneNumber;

    /**
     * <b>Optional.</b><br>
     * User's verified email address, available only for “email” type
     */
    @JsonProperty("email")
    private final String email;

    /**
     * <b>Optional.</b><br>
     * Array of encrypted files with documents provided by the user, available for “utility_bill”,
     * “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types.
     * Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Valid
    @JsonProperty("files")
    private final List<PassportFile> files;

    /**
     * <b>Optional.</b><br>
     * Encrypted file with the front side of the document, provided by the user.
     * Available for “passport”, “driver_license”, “identity_card” and “internal_passport”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Valid
    @JsonProperty("front_side")
    private final PassportFile frontSide;

    /**
     * <b>Optional.</b><br>
     * Encrypted file with the reverse side of the document, provided by the user.
     * Available for “driver_license” and “identity_card”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Valid
    @JsonProperty("reverse_side")
    private final PassportFile reverseSide;

    /**
     * <b>Optional.</b><br>
     * Encrypted file with the selfie of the user holding a document, provided by the user;
     * available for “passport”, “driver_license”, “identity_card” and “internal_passport”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Valid
    @JsonProperty("selfie")
    private final PassportFile selfie;

    /**
     * <b>Optional.</b><br>
     * Array of encrypted files with translated versions of documents provided by the user.
     * Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”,
     * “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types.
     * Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Valid
    @JsonProperty("translation")
    private final List<PassportFile> translation;

    /**
     * Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    @NotNull
    @JsonProperty("hash")
    private final String hash;
}
