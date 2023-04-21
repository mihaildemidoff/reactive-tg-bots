package io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * The section of the user's Telegram Passport.
 */
@RequiredArgsConstructor
public enum PassportElementErrorSource {

    /**
     * data
     */
    DATA("data"),

    /**
     * front_side
     */
    FRONT_SIDE("front_side"),

    /**
     * reverse_side
     */
    REVERSE_SIDE("reverse_side"),

    /**
     * selfie
     */
    SELFIE("selfie"),

    /**
     * file
     */
    FILE("file"),

    /**
     * files
     */
    FILES("files"),

    /**
     * translation_file
     */
    TRANSLATION_FILE("translation_file"),

    /**
     * translation_files
     */
    TRANSLATION_FILES("translation_files"),

    /**
     * unspecified
     */
    UNSPECIFIED("unspecified");

    /**
     * String value of enum
     */
    private final String value;

    /**
     * Returns string representation of enum.
     *
     * @return string value of enum
     */
    @JsonValue
    public String toValue() {
        return value;
    }

    /**
     * Finds enum value for provided string.
     *
     * @param source string representation of enum
     * @return found enum or null if enum not found
     */
    @JsonCreator
    public static PassportElementErrorSource fromValue(final String source) {
        return Stream.of(PassportElementErrorSource.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
