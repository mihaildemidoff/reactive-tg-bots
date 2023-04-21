package io.github.mihaildemidoff.reactive.tg.bots.model.methods.games.score.set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to set the score of the specified user in a game message.
 * On success the {@link Message} is returned.
 * Returns an error, if the new score is not greater than the user's current score in the
 * chat and force is False.
 *
 * @see <a href="https://core.telegram.org/bots/api#setgamescore">setGameScore</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SetGameScoreMethod extends AbstractSetGameScoreMethod<Message> {

    /**
     * Unique identifier for the target chat
     */
    @NotNull
    @JsonProperty("chat_id")
    private final Long chatId;

    /**
     * Identifier of the sent message
     */
    @NotNull
    @JsonProperty("message_id")
    private final Long messageId;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }
}
