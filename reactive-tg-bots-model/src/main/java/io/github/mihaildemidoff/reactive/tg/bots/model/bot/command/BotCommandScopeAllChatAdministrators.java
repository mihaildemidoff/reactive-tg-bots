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
 * Represents the scope of bot commands, covering all group and supergroup chat administrators.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopeallchatadministrators">
 * BotCommandScopeAllChatAdministrators</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeAllChatAdministrators implements BotCommandScope {

    /**
     * Scope type, must be all_chat_administrators
     */
    @NotNull
    @JsonProperty("type")
    private final BotCommandScopeType type = BotCommandScopeType.ALL_CHAT_ADMINISTRATORS;

}
