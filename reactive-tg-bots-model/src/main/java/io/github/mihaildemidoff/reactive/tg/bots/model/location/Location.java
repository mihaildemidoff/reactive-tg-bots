package io.github.mihaildemidoff.reactive.tg.bots.model.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a point on the map.
 *
 * @see <a href="https://core.telegram.org/bots/api#location">Location</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    /**
     * Longitude as defined by sender
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;

    /**
     * Latitude as defined by sender
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * <b>Optional.</b><br>
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @JsonProperty("horizontal_accuracy")
    private final Double horizontalAccuracy;

    /**
     * <b>Optional.</b><br>
     * Time relative to the message sending date, during which the location can be updated; in seconds.
     * For active live locations only.
     */
    @JsonProperty("live_period")
    private final Long livePeriod;

    /**
     * <b>Optional.</b><br>
     * The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    @JsonProperty("heading")
    private final Long heading;

    /**
     * <b>Optional.</b><br>
     * The maximum distance for proximity alerts about approaching another chat member, in meters.
     * For sent live locations only.
     */
    @JsonProperty("proximity_alert_radius")
    private final Long proximityAlertRadius;

}
