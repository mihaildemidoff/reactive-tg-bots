package io.github.mihaildemidoff.reactive.tg.bots.model.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains basic information about a successful payment.
 *
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessfulPayment {

    /**
     * Three-letter ISO 4217 currency code
     */
    @NotNull
    @JsonProperty("currency")
    private final String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example, for a price of
     * US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the
     * decimal point for each currency (2 for the majority of currencies).
     */
    @NotNull
    @JsonProperty("total_amount")
    private final Long totalAmount;

    /**
     * Bot specified invoice payload
     */
    @NotNull
    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    /**
     * <b>Optional.</b><br>
     * Identifier of the shipping option chosen by the user
     */
    @JsonProperty("shipping_option_id")
    private final String shoppingOptionId;

    /**
     * <b>Optional.</b><br>
     * Order information provided by the user
     */
    @Valid
    @JsonProperty("order_info")
    private final OrderInfo orderInfo;

    /**
     * Telegram payment identifier
     */
    @NotNull
    @JsonProperty("telegram_payment_charge_id")
    private final String telegramPaymentChargeId;

    /**
     * Provider payment identifier
     */
    @NotNull
    @JsonProperty("provider_payment_charge_id")
    private final String providerPaymentChargeId;
}
