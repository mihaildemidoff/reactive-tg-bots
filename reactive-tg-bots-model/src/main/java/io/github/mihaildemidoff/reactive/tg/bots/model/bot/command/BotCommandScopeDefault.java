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
 * Represents the default scope of bot commands.
 * Default commands are used if no commands with a narrower scope are specified for the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommandscopedefault">BotCommandScopeDefault</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommandScopeDefault implements BotCommandScope {

    /**
     * Scope type, must be default
     */
    @NotNull
    @JsonProperty("type")
    private final BotCommandScopeType type = BotCommandScopeType.DEFAULT;

}
