package io.github.mihaildemidoff.reactive.tg.bots.model.inline.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * MIME type of the thumbnail
 */
@RequiredArgsConstructor
public enum ThumbnailMimeType {

    /**
     * image/jpeg
     */
    JPEG("image/jpeg"),

    /**
     * image/gif
     */
    GIF("image/gif"),

    /**
     * video/mp4
     */
    MP4("video/mp4");

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
    public static ThumbnailMimeType fromValue(final String source) {
        return Stream.of(ThumbnailMimeType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
