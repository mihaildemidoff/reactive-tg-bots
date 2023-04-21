package io.github.mihaildemidoff.reactive.tg.bots.model.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object contains information about one answer option in a poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#polloption">PollOption</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollOption {

    /**
     * Option text, 1-100 characters
     */
    @Size(min = 1, max = 100)
    @NotNull
    @JsonProperty("text")
    private final String text;

    /**
     * Number of users that voted for this option
     */
    @NotNull
    @JsonProperty("voter_count")
    private final Long voterCount;

}
