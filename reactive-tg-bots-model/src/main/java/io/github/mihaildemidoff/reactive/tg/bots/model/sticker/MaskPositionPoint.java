package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * The part of the face relative to which the mask should be placed.
 */
@RequiredArgsConstructor
public enum MaskPositionPoint {

    /**
     * forehead
     */
    FOREHEAD("forehead"),

    /**
     * eyes
     */
    EYES("eyes"),

    /**
     * mouth
     */
    MOUTH("mouth"),

    /**
     * chin
     */
    CHIN("chin");

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
    public static MaskPositionPoint fromValue(final String source) {
        return Stream.of(MaskPositionPoint.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
