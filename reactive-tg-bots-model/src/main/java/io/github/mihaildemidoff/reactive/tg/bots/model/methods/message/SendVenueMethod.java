package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.ReplyMarkup;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Use this method to send information about a venue.
 * On success, the sent {@link io.github.mihaildemidoff.reactive.tg.bots.model.message.Message} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendvenue">sendVenue</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendVenueMethod implements TypedBotMethodDefinition<Message> {

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("message_id")
    private final String messageId;

    /**
     * Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Latitude of the venue
     */
    @NotNull
    @JsonProperty("latitude")
    private final Double latitude;

    /**
     * Longitude of the venue
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

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    private final Boolean disableNotification;

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    @JsonProperty("protect_content")
    private final Boolean protectContent;

    /**
     * If the message is a reply, ID of the original message
     */
    @JsonProperty("reply_to_message_id")
    private final Long replyToMessageId;

    /**
     * Pass True if the message should be sent even if the specified replied-to message is not found
     */
    @JsonProperty("allow_sending_without_reply")
    private final Boolean allowSendingWithoutReply;

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard,
     * instructions to remove reply keyboard or to force a reply from the user.
     */
    @JsonProperty("reply_markup")
    private final ReplyMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_VENUE;
    }
}
