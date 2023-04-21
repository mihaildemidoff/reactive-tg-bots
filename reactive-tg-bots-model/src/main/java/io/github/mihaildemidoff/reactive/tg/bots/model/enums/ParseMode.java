package io.github.mihaildemidoff.reactive.tg.bots.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Mode for parsing entities.
 *
 * @see <a href="https://core.telegram.org/bots/api#formatting-options">formatting options</a> for more details.
 */
@RequiredArgsConstructor
public enum ParseMode {

    /**
     * @see <a href="https://core.telegram.org/bots/api#markdown-style">Markdown style</a>
     */
    MARKDOWN("Markdown"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#markdownv2-style">MarkdownV2 style</a>
     */
    MARKDOWN_V2("MarkdownV2"),

    /**
     * @see <a href="https://core.telegram.org/bots/api#html-style">HTML style</a>
     */
    HTML("HTML");

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
    public static ParseMode fromValue(final String source) {
        return Stream.of(ParseMode.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
