package io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.validation.PassportElementErrorSectionTypeSubset;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Represents an issue with a list of scans.
 * The error is considered resolved when the list of files containing the scans changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">PassportElementErrorFiles</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportElementErrorFiles extends PassportElementError {

    /**
     * Error source, must be files
     */
    @NotNull
    @JsonProperty("source")
    private final PassportElementErrorSource source = PassportElementErrorSource.FILES;

    /**
     * The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”,
     * “rental_agreement”, “passport_registration”, “temporary_registration”
     */
    @PassportElementErrorSectionTypeSubset(anyOf = {
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
     * List of base64-encoded file hashes
     */
    @NotEmpty
    @NotNull
    @JsonProperty("file_hashes")
    private final List<@Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$") String> fileHashes;

}
