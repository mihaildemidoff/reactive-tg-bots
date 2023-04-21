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
 * Represents an issue in one of the data fields that was provided by the user.
 * The error is considered resolved when the field's value changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrordatafield">PassportElementErrorDataField</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassportElementErrorDataField extends PassportElementError {

    /**
     * Error source, must be data
     */
    @NotNull
    @JsonProperty("source")
    private final PassportElementErrorSource source = PassportElementErrorSource.DATA;

    /**
     * The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”,
     * “driver_license”, “identity_card”, “internal_passport”, “address”
     */
    @PassportElementErrorSectionTypeSubset(anyOf = {
            PassportElementErrorSectionType.PERSONAL_DETAILS,
            PassportElementErrorSectionType.PASSPORT,
            PassportElementErrorSectionType.DRIVER_LICENSE,
            PassportElementErrorSectionType.IDENTITY_CARD,
            PassportElementErrorSectionType.INTERNAL_PASSPORT,
            PassportElementErrorSectionType.ADDRESS
    })
    @NotNull
    @JsonProperty("type")
    private final PassportElementErrorSectionType type;

    /**
     * Name of the data field which has the error
     */
    @NotNull
    @JsonProperty("field_name")
    private final String fieldName;

    /**
     * Base64-encoded data hash
     */
    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")
    @NotNull
    @JsonProperty("data_hash")
    private final String dataHash;

}
