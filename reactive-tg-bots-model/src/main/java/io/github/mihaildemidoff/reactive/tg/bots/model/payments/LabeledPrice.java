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
 * This object represents a portion of the price for goods or services.
 *
 * @see <a href="https://core.telegram.org/bots/api#labeledprice">LabeledPrice</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabeledPrice {

    /**
     * Portion label
     */
    @NotNull
    @JsonProperty("label")
    private final String label;

    /**
     * Price of the product in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the
     * number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    @NotNull
    @JsonProperty("amount")
    private final Long amount;

}
