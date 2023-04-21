package io.github.mihaildemidoff.reactive.tg.bots.model.sticker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Sticker format
 */
@RequiredArgsConstructor
public enum StickerFormat {

    /**
     * static
     */
    STATIC("static"),

    /**
     * animated
     */
    ANIMATED("animated"),

    /**
     * video
     */
    VIDEO("video");

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
    public static StickerFormat fromValue(final String source) {
        return Stream.of(StickerFormat.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
