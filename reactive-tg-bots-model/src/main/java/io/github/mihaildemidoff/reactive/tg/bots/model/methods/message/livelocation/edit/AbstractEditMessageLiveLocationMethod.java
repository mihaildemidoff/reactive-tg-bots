package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.livelocation.edit;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.InlineKeyboardMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Use this method to edit live location messages. A location can be edited until its live_period expires or editing is
 * explicitly disabled by a call to stopMessageLiveLocation.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagelivelocation">editMessageLiveLocation</a>
 * @see EditMessageLiveLocationMethod
 * @see EditInlineMessageLiveLocationMethod
 */
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEditMessageLiveLocationMethod<RESPONSE> implements BaseBotMethodDefinition<RESPONSE> {

    /**
     * Latitude of new location
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Longitude of new location
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @DecimalMax("1500.00")
    @DecimalMin("0.00")
    @JsonProperty("horizontal_accuracy")
    private final Double horizontalAccuracy;

    /**
     * Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     */
    @Max(360)
    @Min(1)
    @JsonProperty("heading")
    private final Long heading;

    /**
     * The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1
     * and 100000 if specified.
     */
    @Max(100000)
    @Min(1)
    @JsonProperty("proximity_alert_radius")
    private final Long proximityAlertRadius;

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    @Valid
    @JsonProperty("reply_markup")
    private final InlineKeyboardMarkup replyMarkup;

    @Override
    public BotMethod getMethod() {
        return BotMethod.EDIT_MESSAGE_LIVE_LOCATION;
    }
}
