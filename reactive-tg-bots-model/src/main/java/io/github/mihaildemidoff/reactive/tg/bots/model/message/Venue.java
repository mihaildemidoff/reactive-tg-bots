package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.location.Location;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a venue.
 *
 * @see <a href="https://core.telegram.org/bots/api#venue">Venue</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    /**
     * Venue location. Can't be a live location
     */
    @Valid
    @NotNull
    @JsonProperty("location")
    private final Location location;

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
     * Foursquare identifier of the venue
     */
    @JsonProperty("foursquare_id")
    private final String foursquareId;

    /**
     * <b>Optional.</b><br>
     * Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium”
     * or “food/icecream”.)
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
     * (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
     */
    @JsonProperty("google_place_type")
    private final String googlePlaceType;

}
