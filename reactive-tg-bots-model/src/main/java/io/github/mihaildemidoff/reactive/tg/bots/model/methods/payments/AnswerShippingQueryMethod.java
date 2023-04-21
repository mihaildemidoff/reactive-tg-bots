package io.github.mihaildemidoff.reactive.tg.bots.model.methods.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.ShippingOption;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API will
 * send an {@link io.github.mihaildemidoff.reactive.tg.bots.model.update.Update} with a shipping_query field to the bot.
 * Use this method to reply to shipping queries.
 * On success, True is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#answershippingquery">answerShippingQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerShippingQueryMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the query to be answered
     */
    @NotNull
    @JsonProperty("shipping_query_id")
    private final String shippingQueryId;

    /**
     * Pass True if delivery to the specified address is possible and False if there are any problems
     * (for example, if delivery to the specified address is not possible)
     */
    @NotNull
    @JsonProperty("ok")
    private final Boolean ok;

    /**
     * Required if ok is True. A JSON-serialized array of available shipping options.
     */
    @Valid
    @JsonProperty("shipping_options")
    private final List<ShippingOption> shippingOptions;

    /**
     * Required if ok is False. Error message in human readable form that explains why it is impossible to complete
     * the order (e.g. "Sorry, delivery to your desired address is unavailable').
     * Telegram will display this message to the user.
     */
    @JsonProperty("error_message")
    private final String errorMessage;

    @Override
    public BotMethod getMethod() {
        return BotMethod.ANSWER_SHIPPING_QUERY;
    }
}
