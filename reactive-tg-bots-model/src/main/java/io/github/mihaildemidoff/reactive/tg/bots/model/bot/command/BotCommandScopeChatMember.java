package io.github.mihaildemidoff.reactive.tg.bots.model.bot.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the scope of bot commands, covering a specific member of a group or supergroup chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechatmember">BotCommandScopeChatMember</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeChatMember implements BotCommandScope {

    /**
     * Scope type, must be chat_member
     */
    @NotNull
    @JsonProperty("type")
    private final BotCommandScopeType type = BotCommandScopeType.CHAT_MEMBER;

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Unique identifier of the target user
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

}
