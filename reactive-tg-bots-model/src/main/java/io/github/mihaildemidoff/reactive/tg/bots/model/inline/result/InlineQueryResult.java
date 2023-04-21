package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 20 types:
 * <b>Note:</b> All URLs passed in inline query results will be available to end users and therefore must be assumed to
 * be public.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresult">InlineQueryResult</a>
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class InlineQueryResult {

    /**
     * Unique identifier for this result, 1-64 bytes
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * <b>Optional.</b><br>
     * Inline keyboard attached to the message
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    /**
     * Get type of the inline query result.
     *
     * @return type of the inline query result.
     */
    public abstract InlineQueryResultType getType();

}
