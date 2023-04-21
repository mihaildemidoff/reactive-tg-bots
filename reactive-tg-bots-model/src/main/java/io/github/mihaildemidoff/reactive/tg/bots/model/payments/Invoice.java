package io.github.mihaildemidoff.reactive.tg.bots.model.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains basic information about an invoice.
 *
 * @see <a href="https://core.telegram.org/bots/api#invoice">Invoice</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    /**
     * Product name
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * Product description
     */
    @NotNull
    @JsonProperty("description")
    private final String description;

    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice
     */
    @NotNull
    @JsonProperty("start_parameter")
    private final String startParameter;

    /**
     * Three-letter ISO 4217 currency code
     */
    @NotNull
    @JsonProperty("currency")
    private final String currency;

    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the
     * number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @NotNull
    @JsonProperty("total_amount")
    private final Long totalAmount;

}
