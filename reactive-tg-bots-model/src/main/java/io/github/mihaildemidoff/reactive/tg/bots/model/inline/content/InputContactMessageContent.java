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
 * Represents the content of a contact message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputcontactmessagecontent">InputContactMessageContent</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputContactMessageContent implements InputMessageContent {

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
    @NotNull
    @JsonProperty("vcard")
    private final String vcard;

}
