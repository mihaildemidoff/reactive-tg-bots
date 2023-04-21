package io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This object represents an error in the Telegram Passport element which was submitted that should be resolved
 * by the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerror">PassportElementError</a>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "source")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PassportElementErrorDataField.class, name = "data"),
        @JsonSubTypes.Type(value = PassportElementErrorFile.class, name = "file"),
        @JsonSubTypes.Type(value = PassportElementErrorFiles.class, name = "files"),
        @JsonSubTypes.Type(value = PassportElementErrorFrontSide.class, name = "front_side"),
        @JsonSubTypes.Type(value = PassportElementErrorReverseSide.class, name = "reverse_side"),
        @JsonSubTypes.Type(value = PassportElementErrorSelfie.class, name = "selfie"),
        @JsonSubTypes.Type(value = PassportElementErrorTranslationFile.class, name = "translation_file"),
        @JsonSubTypes.Type(value = PassportElementErrorTranslationFiles.class, name = "translation_files"),
        @JsonSubTypes.Type(value = PassportElementErrorUnspecified.class, name = "unspecified")
})
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PassportElementError {

    /**
     * Error message
     */
    @NotNull
    @JsonProperty("message")
    private final String message;

    /**
     * Element error source
     *
     * @return element error source
     */
    public abstract PassportElementErrorSource getSource();

}
