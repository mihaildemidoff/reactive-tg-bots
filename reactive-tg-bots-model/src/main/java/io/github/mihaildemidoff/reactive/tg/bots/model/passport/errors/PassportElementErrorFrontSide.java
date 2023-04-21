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
 * Represents an issue with the front side of a document.
 * The error is considered resolved when the file with the front side of the document changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfrontside">PassportElementErrorFrontSide</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportElementErrorFrontSide extends PassportElementError {

    /**
     * Error source, must be front_side
     */
    @NotNull
    @JsonProperty("source")
    private final PassportElementErrorSource source = PassportElementErrorSource.FRONT_SIDE;

    /**
     * The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”,
     * “identity_card”, “internal_passport”
     */
    @PassportElementErrorSectionTypeSubset(anyOf = {
            PassportElementErrorSectionType.PASSPORT,
            PassportElementErrorSectionType.DRIVER_LICENSE,
            PassportElementErrorSectionType.IDENTITY_CARD,
            PassportElementErrorSectionType.INTERNAL_PASSPORT
    })
    @NotNull
    @JsonProperty("type")
    private final PassportElementErrorSectionType type;

    /**
     * Base64-encoded hash of the file with the front side of the document
     */
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")
    @NotNull
    @JsonProperty("file_hash")
    private final String fileHash;

}
