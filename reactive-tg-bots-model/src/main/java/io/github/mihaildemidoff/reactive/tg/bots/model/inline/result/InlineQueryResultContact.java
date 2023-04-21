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
 * Represents a contact with a phone number. By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the contact.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcontact">InlineQueryResultContact</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultContact extends InlineQueryResult {

    /**
     * Type of the result, must be contact
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.CONTACT;

    /**
     * Contact's phone number
     */
    @NotNull
    @JsonProperty("phone_number")
    private final String phoneNumber;

    /**
     * Contact's first name
     */
    @NotNull
    @JsonProperty("first_name")
    private final String firstName;

    /**
     * <b>Optional.</b><br>
     * Contact's last name
     */
    @JsonProperty("last_name")
    private final String lastName;

    /**
     * <b>Optional.</b><br>
     * Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    @JsonProperty("vcard")
    private final String vcard;

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
     * Content of the message to be sent instead of the contact
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
