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

import java.util.List;

/**
 * This object represents one shipping option.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingoption">ShippingOption</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingOption {

    /**
     * Shipping option identifier
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * Option title
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * List of price portions
     */
    @Valid
    @NotNull
    @JsonProperty("prices")
    private final List<LabeledPrice> prices;
}
