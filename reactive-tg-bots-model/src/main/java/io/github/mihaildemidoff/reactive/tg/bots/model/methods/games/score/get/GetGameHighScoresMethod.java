package io.github.mihaildemidoff.reactive.tg.bots.model.methods.games.score.get;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.ListBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.games.GameHighScore;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to get data for high score tables. Will return the score of the specified user and several of their
 * neighbors in a game.
 * Returns an Array of {@link io.github.mihaildemidoff.reactive.tg.bots.model.games.GameHighScore} objects.
 * <p>
 * This method will currently return scores for the target user, plus two of their closest neighbors on each side.
 * Will also return the top three users if the user and their neighbors are not among them.
 * Please note that this behavior is subject to change.
 *
 * @see <a href="https://core.telegram.org/bots/api#getgamehighscores">getGameHighScores</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGameHighScoresMethod implements ListBotMethodDefinition<GameHighScore> {

    /**
     * Target user id
     */
    @NotNull
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat
     */
    @JsonProperty("chat_id")
    private final Long chatId;

    /**
     * Required if inline_message_id is not specified. Identifier of the sent message
     */
    @JsonProperty("message_id")
    private final Long messageId;

    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    @NotNull
    @JsonProperty("inline_message_id")
    private final String inlineMessageId;

    @Override
    public TypeReference<GenericBotApiResponse<List<GameHighScore>>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.GET_GAME_HIGH_SCORES;
    }
}
