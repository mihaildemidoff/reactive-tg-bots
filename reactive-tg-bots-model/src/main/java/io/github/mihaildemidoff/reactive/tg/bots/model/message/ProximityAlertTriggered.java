package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert
 * set by another user.
 *
 * @see <a href="https://core.telegram.org/bots/api#proximityalerttriggered">ProximityAlertTriggered</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProximityAlertTriggered {

    /**
     * User that triggered the alert
     */
    @Valid
    @NotNull
    @JsonProperty("traveler")
    private final User traveler;

    /**
     * User that set the alert
     */
    @Valid
    @NotNull
    @JsonProperty("watcher")
    private final User watcher;

    /**
     * The distance between the users
     */
    @NotNull
    @JsonProperty("distance")
    private final Long distance;
}
