package io.github.mihaildemidoff.reactive.tg.bots.model.inline.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputlocationmessagecontent">InputLocationMessageContent</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputLocationMessageContent implements InputMessageContent {

    /**
     * Latitude of the location in degrees
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Longitude of the location in degrees
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;

    /**
     * <b>Optional.</b><br>
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @DecimalMax(value = "1500.00")
    @DecimalMin(value = "0.00")
    @JsonProperty("horizontal_accuracy")
    private final Double horizontalAccuracy;

    /**
     * <b>Optional.</b><br>
     * Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    @Max(86400)
    @Min(60)
    @JsonProperty("live_period")
    private final Long livePeriod;

    /**
     * <b>Optional.</b><br>
     * For live locations, a direction in which the user is moving, in degrees.
     * Must be between 1 and 360 if specified.
     */
    @DecimalMax("360.00")
    @DecimalMin("1.00")
    @JsonProperty("heading")
    private final Double heading;

    /**
     * <b>Optional.</b><br>
     * For live locations, a maximum distance for proximity alerts about approaching another chat member,
     * in meters. Must be between 1 and 100000 if specified.
     */
    @DecimalMax("100000.00")
    @DecimalMin("1.00")
    @JsonProperty("proximity_alert_radius")
    private final Double proximityAlertRadius;


}
