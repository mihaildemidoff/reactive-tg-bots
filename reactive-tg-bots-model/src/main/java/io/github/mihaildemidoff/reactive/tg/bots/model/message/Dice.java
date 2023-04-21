package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an animated emoji that displays a random value.
 *
 * @see <a href="https://core.telegram.org/bots/api#dice">Dice</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dice {

    /**
     * Emoji on which the dice throw animation is based
     */
    @NotNull
    @JsonProperty("emoji")
    private final String emoji;

    /**
     * Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji,
     * 1-64 for “🎰” base emoji
     */
    @NotNull
    @JsonProperty("value")
    private Long value;

}
