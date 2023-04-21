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
 * Represents the scope of bot commands, covering all private chats.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallprivatechats">BotCommandScopeAllPrivateChats</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeAllPrivateChats implements BotCommandScope {

    /**
     * Scope type, must be all_group_chats
     */
    @NotNull
    @JsonProperty("type")
    private final BotCommandScopeType type = BotCommandScopeType.ALL_GROUP_CHATS;

}
