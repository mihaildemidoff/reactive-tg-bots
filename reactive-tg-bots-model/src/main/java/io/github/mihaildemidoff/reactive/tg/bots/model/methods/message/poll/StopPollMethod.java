package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.poll;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.poll.Poll;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped
 * {@link io.github.mihaildemidoff.reactive.tg.bots.model.poll.Poll} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#stoppoll">stopPoll</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPollMethod implements TypedBotMethodDefinition<Poll> {

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("chat_id")
    private final String chatId;

    /**
     * Identifier of the original message with the poll
     */
    @NotNull
    @JsonProperty("message_id")
    private final Long messageId;


    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<Poll>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.STOP_POLL;
    }
}
