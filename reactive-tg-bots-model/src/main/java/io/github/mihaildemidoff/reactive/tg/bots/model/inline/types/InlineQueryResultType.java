package io.github.mihaildemidoff.reactive.tg.bots.model.inline.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Type of inline result
 */
@RequiredArgsConstructor
public enum InlineQueryResultType {

    /**
     * article
     */
    ARTICLE("article"),

    /**
     * audio
     */
    AUDIO("audio"),

    /**
     * document
     */
    DOCUMENT("document"),

    /**
     * gif
     */
    GIF("gif"),

    /**
     * mpeg4_gif
     */
    MPEG4_GIF("mpeg4_gif"),

    /**
     * photo
     */
    PHOTO("photo"),

    /**
     * sticker
     */
    STICKER("sticker"),

    /**
     * video
     */
    VIDEO("video"),

    /**
     * voice
     */
    VOICE("voice"),

    /**
     * contact
     */
    CONTACT("contact"),

    /**
     * game
     */
    GAME("game"),

    /**
     * location
     */
    LOCATION("location"),

    /**
     * venue
     */
    VENUE("venue");

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
    public static InlineQueryResultType fromValue(final String source) {
        return Stream.of(InlineQueryResultType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }

}
