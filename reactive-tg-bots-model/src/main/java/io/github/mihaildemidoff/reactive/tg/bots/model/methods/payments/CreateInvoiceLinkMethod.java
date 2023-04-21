package io.github.mihaildemidoff.reactive.tg.bots.model.methods.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.payments.LabeledPrice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Use this method to create a link for an invoice.
 * Returns the created invoice link as String on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#createinvoicelink">createInvoiceLink</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateInvoiceLinkMethod implements BaseBotMethodDefinition<String> {

    /**
     * Product name, 1-32 characters
     */
    @Size(min = 1, max = 32)
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * Product description, 1-255 characters
     */
    @Size(min = 1, max = 255)
    @NotNull
    @JsonProperty("description")
    private final String description;

    /**
     * Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal
     * processes.
     */
    @NotNull
    @JsonProperty("payload")
    private final String payload;

    /**
     * Payment provider token, obtained via @BotFather
     */
    @NotNull
    @JsonProperty("provider_token")
    private final String providerToken;

    /**
     * Three-letter ISO 4217 currency code, see more on currencies
     */
    @NotNull
    @JsonProperty("currency")
    private final String currency;

    /**
     * Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost,
     * delivery tax, bonus, etc.)
     */
    @Valid
    @NotNull
    @JsonProperty("prices")
    private final List<LabeledPrice> prices;

    /**
     * The maximum accepted amount for tips in the smallest units of the currency (integer, not float/double).
     * For example, for a maximum tip of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in currencies.json,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     * Defaults to 0
     */
    @JsonProperty("max_tip_amount")
    private final Long maxTipAmount;

    /**
     * A JSON-serialized array of suggested amounts of tips in the smallest units of the currency
     * (integer, not float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be
     * positive, passed in a strictly increased order and must not exceed max_tip_amount.
     */
    @JsonProperty("suggested_tip_amounts")
    private final List<Long> suggestepTipAmounts;

    /**
     * JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of
     * required fields should be provided by the payment provider.
     */
    @JsonProperty("provider_data")
    private final String providerData;

    /**
     * URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
     * People like it better when they see what they are paying for.
     */
    @JsonProperty("photo_url")
    private final String photoUrl;

    /**
     * Photo size in bytes
     */
    @JsonProperty("photo_size")
    private final Long photoSize;

    /**
     * Photo width
     */
    @JsonProperty("photo_width")
    private final Long photoWidth;

    /**
     * Photo height
     */
    @JsonProperty("photo_height")
    private final Long photoHeight;

    /**
     * Pass True if you require the user's full name to complete the order
     */
    @JsonProperty("need_name")
    private final Boolean needName;

    /**
     * Pass True if you require the user's phone number to complete the order
     */
    @JsonProperty("need_phone_number")
    private final Boolean needPhoneNumber;

    /**
     * Pass True if you require the user's email address to complete the order
     */
    @JsonProperty("need_email")
    private final Boolean needEmail;

    /**
     * Pass True if you require the user's shipping address to complete the order
     */
    @JsonProperty("need_shipping_address")
    private final Boolean needShippingAddress;

    /**
     * Pass True if the user's phone number should be sent to provider
     */
    @JsonProperty("send_phone_number_to_provider")
    private final Boolean sendPhoneNumberToProvider;

    /**
     * Pass True if the user's email address should be sent to provider
     */
    @JsonProperty("send_email_to_provider")
    private final Boolean sendEmailToProvider;

    /**
     * Pass True if the final price depends on the shipping method
     */
    @JsonProperty("is_flexible")
    private final Boolean isFlexible;

    @Override
    public TypeReference<GenericBotApiResponse<String>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.CREATE_INVOICE_LINK;
    }
}
