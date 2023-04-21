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
 * Represents the scope of bot commands, covering a specific chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopechat">BotCommandScopeChat</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeChat implements BotCommandScope {

    /**
     * Scope type, must be chat
     */
    @NotNull
    @JsonProperty("type")
    private final BotCommandScopeType type = BotCommandScopeType.CHAT;

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

}
