package io.github.mihaildemidoff.reactive.tg.bots.model.chat.member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Chat member status.
 */
@RequiredArgsConstructor
public enum ChatMemberStatus {

    /**
     * creator
     */
    CREATOR("creator"),

    /**
     * administrator
     */
    ADMINISTRATOR("administrator"),

    /**
     * member
     */
    MEMBER("member"),

    /**
     * restricted
     */
    RESTRICTED("restricted"),

    /**
     * left
     */
    LEFT("left"),

    /**
     * kicked
     */
    KICKED("kicked");

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
    public static ChatMemberStatus fromValue(final String source) {
        return Stream.of(ChatMemberStatus.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
