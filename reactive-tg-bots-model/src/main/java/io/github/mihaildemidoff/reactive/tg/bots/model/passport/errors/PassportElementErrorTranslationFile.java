package io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.validation.PassportElementErrorSectionTypeSubset;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents an issue with one of the files that constitute the translation of a document. The error is considered
 * resolved when the file changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfile">
 * PassportElementErrorTranslationFile</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportElementErrorTranslationFile extends PassportElementError {

    /**
     * Error source, must be translation_file
     */
    @NotNull
    @JsonProperty("source")
    private final PassportElementErrorSource source = PassportElementErrorSource.TRANSLATION_FILE;

    /**
     * Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”,
     * “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”,
     * “passport_registration”, “temporary_registration”
     */
    @PassportElementErrorSectionTypeSubset(anyOf = {
            PassportElementErrorSectionType.PASSPORT,
            PassportElementErrorSectionType.DRIVER_LICENSE,
            PassportElementErrorSectionType.IDENTITY_CARD,
            PassportElementErrorSectionType.INTERNAL_PASSPORT,
            PassportElementErrorSectionType.UTILITY_BILL,
            PassportElementErrorSectionType.BANK_STATEMENT,
            PassportElementErrorSectionType.RENTAL_AGREEMENT,
            PassportElementErrorSectionType.PASSPORT_REGISTRATION,
            PassportElementErrorSectionType.TEMPORARY_REGISTRATION
    })
    @NotNull
    @JsonProperty("type")
    private final PassportElementErrorSectionType type;

    /**
     * Base64-encoded file hash
     */
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")
    @NotNull
    @JsonProperty("file_hash")
    private final String fileHash;

}
