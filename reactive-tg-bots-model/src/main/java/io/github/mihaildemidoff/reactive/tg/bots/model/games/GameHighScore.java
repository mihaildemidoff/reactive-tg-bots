package io.github.mihaildemidoff.reactive.tg.bots.model.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents one row of the high scores table for a game.
 *
 * @see <a href="https://core.telegram.org/bots/api#gamehighscore">GameHighScore</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameHighScore implements BotApiResponse {

    /**
     * Position in high score table for the game
     */
    @NotNull
    @JsonProperty("position")
    private final Long position;

    /**
     * User
     */
    @Valid
    @NotNull
    @JsonProperty("user")
    private final User user;

    /**
     * Score
     */
    @NotNull
    @JsonProperty("score")
    private final Long score;

}
