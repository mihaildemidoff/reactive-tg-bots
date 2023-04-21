package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
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
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the location.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultlocation">InlineQueryResultLocation</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultLocation extends InlineQueryResult {

    /**
     * Type of the result, must be location
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.LOCATION;

    /**
     * Location latitude in degrees
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Location longitude in degrees
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;

    /**
     * Location title
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @DecimalMin("0.00")
    @DecimalMax("1500.00")
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
    @Max(360)
    @Min(1)
    @JsonProperty("heading")
    private final Long heading;

    /**
     * <b>Optional.</b><br>
     * For live locations, a maximum distance for proximity alerts about approaching another chat member,
     * in meters. Must be between 1 and 100000 if specified.
     */
    @Max(100000)
    @Min(1)
    @JsonProperty("proximity_alert_radius")
    private final Long proximityAlertRadius;

    /**
     * <b>Optional.</b><br>
     * Url of the thumbnail for the result
     */
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    /**
     * <b>Optional.</b><br>
     * Thumbnail width
     */
    @JsonProperty("thumbnail_width")
    private final Long thumbnailWidth;

    /**
     * <b>Optional.</b><br>
     * Thumbnail height
     */
    @JsonProperty("thumbnail_height")
    private final Long thumbnailHeight;

    /**
     * <b>Optional.</b><br>
     * Content of the message to be sent instead of the location
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
