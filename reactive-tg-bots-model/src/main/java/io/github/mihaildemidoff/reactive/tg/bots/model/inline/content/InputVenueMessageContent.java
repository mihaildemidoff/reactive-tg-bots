package io.github.mihaildemidoff.reactive.tg.bots.model.inline.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputvenuemessagecontent">InputVenueMessageContent</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputVenueMessageContent implements InputMessageContent {

    /**
     * Latitude of the venue in degrees
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Longitude of the venue in degrees
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;


    /**
     * Name of the venue
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * Address of the venue
     */
    @NotNull
    @JsonProperty("address")
    private final String address;

    /**
     * <b>Optional.</b><br>
     * Foursquare identifier of the venue, if known
     */
    @JsonProperty("foursquare_id")
    private final String foursquareId;

    /**
     * <b>Optional.</b><br>
     * Foursquare type of the venue, if known. (For example, “arts_entertainment/default”,
     * “arts_entertainment/aquarium” or “food/icecream”.)
     */
    @JsonProperty("foursquare_type")
    private final String foursquareType;

    /**
     * <b>Optional.</b><br>
     * Google Places identifier of the venue
     */
    @JsonProperty("google_place_id")
    private final String googlePlaceId;

    /**
     * <b>Optional.</b><br>
     * Google Places type of the venue.
     */
    @JsonProperty("google_place_type")
    private final String googlePlaceType;

}
