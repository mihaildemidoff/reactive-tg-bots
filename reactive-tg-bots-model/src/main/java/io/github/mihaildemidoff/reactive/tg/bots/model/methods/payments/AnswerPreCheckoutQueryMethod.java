package io.github.mihaildemidoff.reactive.tg.bots.model.methods.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BooleanBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form
 * of an {@link io.github.mihaildemidoff.reactive.tg.bots.model.update.Update} with the field pre_checkout_query.
 * Use this method to respond to such pre-checkout queries.
 * On success, True is returned.
 * <b>Note:</b> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#answerprecheckoutquery">answerPreCheckoutQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerPreCheckoutQueryMethod implements BooleanBotMethodDefinition {

    /**
     * Unique identifier for the query to be answered
     */
    @NotNull
    @JsonProperty("pre_checkout_query_id")
    private final String preCheckoutQueryId;

    /**
     * Specify True if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order.
     * Use False if there are any problems.
     */
    @NotNull
    @JsonProperty("ok")
    private final Boolean ok;

    /**
     * Required if ok is False. Error message in human readable form that explains the reason for failure to proceed
     * with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy
     * filling out your payment details. Please choose a different color or garment!").
     * Telegram will display this message to the user.
     */
    @JsonProperty("error_message")
    private final String errorMessage;

    @Override
    public BotMethod getMethod() {
        return BotMethod.ANSWER_PRE_CHECKOUT_QUERY;
    }
}
