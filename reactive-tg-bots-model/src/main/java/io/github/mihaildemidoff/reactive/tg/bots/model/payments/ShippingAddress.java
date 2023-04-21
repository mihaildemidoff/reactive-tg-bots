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
 * This object represents a shipping address.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingaddress">ShippingAddress</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingAddress {

    /**
     * Two-letter ISO 3166-1 alpha-2 country code
     */
    @NotNull
    @JsonProperty("country_code")
    private final String countryCode;

    /**
     * State, if applicable
     */
    @NotNull
    @JsonProperty("state")
    private final String state;

    /**
     * City
     */
    @NotNull
    @JsonProperty("city")
    private final String city;

    /**
     * First line for the address
     */
    @NotNull
    @JsonProperty("street_line1")
    private final String streetLine1;

    /**
     * Second line for the address
     */
    @NotNull
    @JsonProperty("street_line2")
    private final String streetLine2;

    /**
     * Address post code
     */
    @NotNull
    @JsonProperty("post_code")
    private final String postCode;
}
