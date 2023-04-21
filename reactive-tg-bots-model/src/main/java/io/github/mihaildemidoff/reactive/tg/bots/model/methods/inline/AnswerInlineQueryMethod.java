package io.github.mihaildemidoff.reactive.tg.bots.model.methods.inline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.InlineQueryResultsButton;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.result.InlineQueryResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to send answers to an inline query. On success, True is returned.
 * No more than 50 results per query are allowed.
 *
 * @see <a href="https://core.telegram.org/bots/api#answerinlinequery">answerInlineQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerInlineQueryMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the answered query
     */
    @NotNull
    @JsonProperty("inline_query_id")
    private final String inlineQueryId;

    /**
     * A JSON-serialized array of results for the inline query
     */
    @Valid
    @NotNull
    @JsonProperty("results")
    private final List<InlineQueryResult> results;

    /**
     * The maximum amount of time in seconds that the result of the inline query may be cached on the server.
     * Defaults to 300.
     */
    @JsonProperty("cache_time")
    // TODO: change to duration
    private final Long cacheTime;

    /**
     * Pass True if results may be cached on the server side only for the user that sent the query. By default, results
     * may be returned to any user who sends the same query
     */
    @JsonProperty("is_personal")
    private final Boolean isPersonal;

    /**
     * Pass the offset that a client should send in the next query with the same text to receive more results.
     * Pass an empty string if there are no more results or if you don't support pagination.
     * Offset length can't exceed 64 bytes.
     */
    @JsonProperty("next_offset")
    private final String nextOffset;

    /**
     * A JSON-serialized object describing a button to be shown above inline query results
     */
    @Valid
    @JsonProperty("button")
    private final InlineQueryResultsButton button;

    @Override
    public BotMethod getMethod() {
        return BotMethod.ANSWER_INLINE_QUERY;
    }
}
