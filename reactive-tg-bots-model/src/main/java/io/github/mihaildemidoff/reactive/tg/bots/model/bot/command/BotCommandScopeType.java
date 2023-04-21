package io.github.mihaildemidoff.reactive.tg.bots.model.bot.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Bot command scope type.
 */
@RequiredArgsConstructor
public enum BotCommandScopeType {

    /**
     * default
     */
    DEFAULT("default"),

    /**
     * all_private_chats
     */
    ALL_PRIVATE_CHATS("all_private_chats"),

    /**
     * all_group_chats
     */
    ALL_GROUP_CHATS("all_group_chats"),

    /**
     * all_chat_administrators
     */
    ALL_CHAT_ADMINISTRATORS("all_chat_administrators"),

    /**
     * chat
     */
    CHAT("chat"),

    /**
     * chat_administrators
     */
    CHAT_ADMINISTRATORS("chat_administrators"),

    /**
     * chat_member
     */
    CHAT_MEMBER("chat_member");

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
    public static BotCommandScopeType fromValue(final String source) {
        return Stream.of(BotCommandScopeType.values())
                .filter(mode -> Objects.equals(mode.value, source))
                .findFirst()
                .orElse(null);
    }
}
