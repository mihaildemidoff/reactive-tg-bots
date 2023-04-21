package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a venue. By default, the venue will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">InlineQueryResultVenue</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultVenue extends InlineQueryResult {

    /**
     * Type of the result, must be venue
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.VENUE;

    /**
     * Latitude of the venue location in degrees
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Longitude of the venue location in degrees
     */
    @NotNull
    @JsonProperty("longitude")
    private final Double longitude;

    /**
     * Title of the venue
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
     * Foursquare identifier of the venue if known
     */
    @JsonProperty("foursquare_id")
    private final String foursquareId;

    /**
     * <b>Optional.</b><br>
     * Foursquare type of the venue, if known.
     * (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
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
     * Content of the message to be sent instead of the venue
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
