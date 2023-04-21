package io.github.mihaildemidoff.reactive.tg.bots.model.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains information about an incoming shipping query.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingquery">ShippingQuery</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingQuery {
    /**
     * Unique query identifier
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * User who sent the query
     */
    @Valid
    @NotNull
    @JsonProperty("from")
    private final User from;

    /**
     * Bot specified invoice payload
     */
    @NotNull
    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    /**
     * User specified shipping address
     */
    @Valid
    @NotNull
    @JsonProperty("shipping_address")
    private final ShippingAddress shippingAddress;
}
