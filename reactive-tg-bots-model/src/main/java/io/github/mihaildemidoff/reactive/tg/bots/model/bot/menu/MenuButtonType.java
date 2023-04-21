package io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Type of menu button.
 */
@RequiredArgsConstructor
public enum MenuButtonType {

    /**
     * commands
     */
    COMMANDS("commands"),

    /**
     * default
     */
    WEB_APP("web_app"),

    /**
     * default
     */
    DEFAULT("default");

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
    public static MenuButtonType fromValue(final String source) {
        return Stream.of(MenuButtonType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
