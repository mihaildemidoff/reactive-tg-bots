package io.github.mihaildemidoff.reactive.tg.bots.model.bot.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a menu button, which opens the bot's list of commands.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttoncommands">MenuButtonCommands</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuButtonCommands implements MenuButton {

    /**
     * Type of the button, must be commands
     */
    @NotNull
    @JsonProperty("type")
    private final MenuButtonType type = MenuButtonType.COMMANDS;
}
