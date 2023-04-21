package io.github.mihaildemidoff.reactive.tg.bots.model.methods.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.SentWebAppMessage;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.result.InlineQueryResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to set the result of an interaction with a Web App and send a corresponding message on behalf of the
 * user to the chat from which the query originated.
 * On success, a {@link io.github.mihaildemidoff.reactive.tg.bots.model.inline.SentWebAppMessage} object is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#answerwebappquery">answerWebAppQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerWebAppQueryMethod implements TypedBotMethodDefinition<SentWebAppMessage> {

    /**
     * Unique identifier for the query to be answered
     */
    @NotNull
    @JsonProperty("web_app_query_id")
    private final Long webAppQueryId;

    /**
     * A JSON-serialized object describing the message to be sent
     */
    @Valid
    @NotNull
    @JsonProperty("result")
    private final InlineQueryResult result;

    @Override
    public TypeReference<GenericBotApiResponse<SentWebAppMessage>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.ANSWER_WEB_APP_QUERY;
    }
}
