package io.github.mihaildemidoff.reactive.tg.bots.model.methods.games.score.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Use this method to set the score of the specified user in a game message. Returns an error, if the new score is
 * not greater than the user's current score in the chat and force is False.
 *
 * @see <a href="https://core.telegram.org/bots/api#setgamescore">setGameScore</a>
 * @see SetGameScoreMethod
 * @see SetInlineGameScoreMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractSetGameScoreMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * User identifier
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * New score, must be non-negative
     */
    @NotNull
    @JsonProperty("score")
    private final Long score;

    /**
     * Pass True if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
     */
    @JsonProperty("force")
    private final Boolean force;

    /**
     * Pass True if the game message should not be automatically edited to include the current scoreboard
     */
    @JsonProperty("disable_edit_message")
    private final Boolean disableEditMessage;

    @Override
    public BotMethod getMethod() {
        return BotMethod.SET_GAME_SCORE;
    }
}
