package io.github.mihaildemidoff.reactive.tg.bots.model.chat;

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
 * Represents a location to which a chat is connected.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatlocation">ChatLocation</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatLocation {
    /**
     * The location to which the supergroup is connected. Can't be a live location.
     */
    @Valid
    @NotNull
    @JsonProperty("location")
    private final Location location;

    /**
     * Location address; 1-64 characters, as defined by the chat owner
     */
    @Valid
    @NotNull
    @JsonProperty("address")
    private final String address;
}
