package io.github.mihaildemidoff.reactive.tg.bots.model.bot.command;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object represents the scope to which bot commands are applied.
 * <p>
 * <b>Determining list of commands</b>
 * </p>
 * The following algorithm is used to determine the list of commands for a particular user viewing the bot menu.
 * The first list of commands which is set is returned:
 *
 * <p>
 * <b>Commands in the chat with the bot</b>
 * </p>
 * <ul>
 * <li>botCommandScopeChat + language_code</li>
 * <li>botCommandScopeChat</li>
 * <li>botCommandScopeAllPrivateChats + language_code</li>
 * <li>botCommandScopeAllPrivateChats</li>
 * <li>botCommandScopeDefault + language_code</li>
 * <li>botCommandScopeDefault</li>
 * </ul>
 * <p>
 * <b>Commands in group and supergroup chats</b>
 * </p>
 * <ul>
 * <li>botCommandScopeChatMember + language_code</li>
 * <li>botCommandScopeChatMember</li>
 * <li>botCommandScopeChatAdministrators + language_code (administrators only)</li>
 * <li>botCommandScopeChatAdministrators (administrators only)</li>
 * <li>botCommandScopeChat + language_code</li>
 * <li>botCommandScopeChat</li>
 * <li>botCommandScopeAllChatAdministrators + language_code (administrators only)</li>
 * <li>botCommandScopeAllChatAdministrators (administrators only)</li>
 * <li>botCommandScopeAllGroupChats + language_code</li>
 * <li>botCommandScopeAllGroupChats</li>
 * <li>botCommandScopeDefault + language_code</li>
 * <li>botCommandScopeDefault</li>
 * </ul>
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscope">BotCommandScope</a>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BotCommandScopeAllChatAdministrators.class, name = "all_chat_administrators"),
        @JsonSubTypes.Type(value = BotCommandScopeAllPrivateChats.class, name = "all_group_chats"),
        @JsonSubTypes.Type(value = BotCommandScopeChat.class, name = "chat"),
        @JsonSubTypes.Type(value = BotCommandScopeChatAdministrators.class, name = "chat_administrators"),
        @JsonSubTypes.Type(value = BotCommandScopeChatMember.class, name = "chat_member"),
        @JsonSubTypes.Type(value = BotCommandScopeDefault.class, name = "default")
})
public interface BotCommandScope {

    /**
     * Type of bot command scope
     *
     * @return type of scope
     */
    BotCommandScopeType getType();

}
