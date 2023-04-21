package io.github.mihaildemidoff.reactive.tg.bots.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">MessageAutoDeleteTimerChanged</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageAutoDeleteTimerChanged {

    /**
     * New auto-delete time for messages in the chat; in seconds
     */
    @NotNull
    @JsonProperty("message_auto_delete_time")
    private final Long messageAutoDeleteTime;
}
