package io.github.mihaildemidoff.reactive.tg.bots.model.poll;

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

import java.util.List;

/**
 * This object represents an answer of a user in a non-anonymous poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#pollanswer">PollAnswer</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollAnswer {

    /**
     * Unique poll identifier
     */
    @NotNull
    @JsonProperty("poll_id")
    private final String pollId;

    /**
     * The user, who changed the answer to the poll
     */
    @Valid
    @NotNull
    @JsonProperty("user")
    private final User user;

    /**
     * 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote.
     */
    @NotNull
    @JsonProperty("option_ids")
    private final List<Long> optionIds;
}
