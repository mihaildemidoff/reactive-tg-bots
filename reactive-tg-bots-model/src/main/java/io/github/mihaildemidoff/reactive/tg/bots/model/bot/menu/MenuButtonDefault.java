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
 * Describes that no specific value for the menu button was set.
 *
 * @see <a href="https://core.telegram.org/bots/api#menubuttondefault">MenuButtonDefault</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuButtonDefault implements MenuButton {

    /**
     * Type of the button, must be default
     */
    @NotNull
    @JsonProperty("type")
    private final MenuButtonType type = MenuButtonType.DEFAULT;
}
