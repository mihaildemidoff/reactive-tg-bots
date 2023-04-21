package io.github.mihaildemidoff.reactive.tg.bots.model.videochat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a service message about a video chat ended in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatended">VideoChatEnded</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoChatEnded {

    /**
     * This object represents a service message about a video chat ended in the chat.
     */
    @NotNull
    @JsonProperty("duration")
    private final Long duration;

}
