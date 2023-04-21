package io.github.mihaildemidoff.reactive.tg.bots.model.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Type of input media
 */
@RequiredArgsConstructor
public enum InputMediaType {
    /**
     * photo
     */
    PHOTO("photo"),

    /**
     * video
     */
    VIDEO("video"),

    /**
     * animation
     */
    ANIMATION("animation"),

    /**
     * audio
     */
    AUDIO("audio"),

    /**
     * document
     */
    DOCUMENT("document");

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
    public static InputMediaType fromValue(final String source) {
        return Stream.of(InputMediaType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
