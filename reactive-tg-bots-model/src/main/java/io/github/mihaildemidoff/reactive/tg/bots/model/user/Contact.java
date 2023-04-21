package io.github.mihaildemidoff.reactive.tg.bots.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a phone contact.
 *
 * @see <a href="https://core.telegram.org/bots/api#contact">Contact</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    /**
     * Contact's phone number
     */
    @NotNull
    @JsonProperty("message_id")
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
    @NotNull
    @JsonProperty("last_name")
    private final String lastName;

    /**
     * <b>Optional.</b><br>
     * Contact's user identifier in Telegram.
     * This number may have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float
     * type are safe for storing this identifier.
     */
    @JsonProperty("user_id")
    private final Long userId;

    /**
     * <b>Optional.</b><br>
     * Additional data about the contact in the form of a vCard
     */
    @JsonProperty("vcard")
    private String vcard;

}
