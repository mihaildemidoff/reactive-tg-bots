package io.github.mihaildemidoff.reactive.tg.bots.model.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents information about an order.
 *
 * @see <a href="https://core.telegram.org/bots/api#orderinfo">OrderInfo</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfo {

    /**
     * <b>Optional.</b><br>
     * User name
     */
    @JsonProperty("name")
    private final String name;

    /**
     * <b>Optional.</b><br>
     * User's phone number
     */
    @JsonProperty("phone_number")
    private final String phoneNumber;

    /**
     * <b>Optional.</b><br>
     * User email
     */
    @JsonProperty("email")
    private final String email;

    /**
     * <b>Optional.</b><br>
     * User shipping address
     */
    @Valid
    @JsonProperty("shipping_address")
    private final ShippingAddress shippingAddress;

}
