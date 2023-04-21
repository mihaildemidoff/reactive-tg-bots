package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Type of the entity.
 */
@RequiredArgsConstructor
public enum MessageEntityType {

    /**
     * mention (@username)
     */
    MENTION("mention"),

    /**
     * hashtag (#hashtag)
     */
    HASHTAG("hashtag"),

    /**
     * cashtag ($USD)
     */
    CASHTAG("cashtag"),

    /**
     * bot_command (/start@jobs_bot)
     */
    BOT_COMMAND("bot_command"),

    /**
     * url (https://telegram.org)
     */
    URL("url"),

    /**
     * email (do-not-reply@telegram.org)
     */
    EMAIL("email"),

    /**
     * phone_number (+1-212-555-0123)
     */
    PHONE_NUMBER("phone_number"),

    /**
     * bold (bold text)
     */
    BOLD("bold"),

    /**
     * italic (italic text)
     */
    ITALIC("italic"),

    /**
     * underline (underlined text)
     */
    UNDERLINE("underline"),

    /**
     * strikethrough (strikethrough text)
     */
    STRIKETHROUGH("strikethrough"),

    /**
     * spoiler (spoiler message)
     */
    SPOILER("spoiler"),

    /**
     * code (monowidth string)
     */
    CODE("code"),

    /**
     * pre (monowidth block)
     */
    PRE("pre"),

    /**
     * text_link (for clickable text URLs)
     */
    TEXT_LINK("text_link"),

    /**
     * text_mention (for users without usernames)
     */
    TEXT_MENTION("text_mention"),

    /**
     * custom_emoji (for inline custom emoji stickers)
     */
    CUSTOM_EMOJI("custom_emoji");

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
    public static MessageEntityType fromValue(final String source) {
        return Stream.of(MessageEntityType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
