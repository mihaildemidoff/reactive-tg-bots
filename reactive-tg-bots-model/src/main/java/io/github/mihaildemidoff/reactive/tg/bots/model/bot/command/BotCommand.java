package io.github.mihaildemidoff.reactive.tg.bots.model.bot.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a bot command.
 *
 * @see <a href="https://core.telegram.org/bots/api#botcommand">BotCommand</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotCommand implements BotApiResponse {

    /**
     * Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores.
     */
    @Pattern(regexp = "^[a-z0-9_]{1,32}$")
    @Size(min = 1, max = 32)
    @NotNull
    @NotBlank
    @JsonProperty("command")
    private final String command;

    /**
     * Description of the command; 1-256 characters.
     */
    @Size(min = 1, max = 256)
    @NotBlank
    @NotNull
    @JsonProperty("description")
    private final String description;
}
