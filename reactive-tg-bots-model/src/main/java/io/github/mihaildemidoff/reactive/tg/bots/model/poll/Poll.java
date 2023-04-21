package io.github.mihaildemidoff.reactive.tg.bots.model.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.List;

/**
 * This object contains information about a poll.
 *
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Poll implements BotApiResponse {

    /**
     * Unique poll identifier
     */
    @NotNull
    @JsonProperty("id")
    private final String id;

    /**
     * Poll question, 1-300 characters
     */
    @NotNull
    @JsonProperty("question")
    private final String question;

    /**
     * List of poll options
     */
    @Valid
    @NotNull
    @JsonProperty("options")
    private final List<PollOption> options;

    /**
     * Total number of users that voted in the poll
     */
    @NotNull
    @JsonProperty("total_voter_count")
    private final Long totalVoterCount;

    /**
     * True, if the poll is closed
     */
    @NotNull
    @JsonProperty("is_closed")
    private final Boolean isClosed;

    /**
     * True, if the poll is anonymous
     */
    @NotNull
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * Poll type, currently can be “regular” or “quiz”
     */
    @NotNull
    @JsonProperty("type")
    private final PollType type;

    /**
     * True, if the poll allows multiple answers
     */
    @NotNull
    @JsonProperty("allows_multiple_answers")
    private final Boolean allowsMultipleAnswers;

    /**
     * <b>Optional.</b><br>
     * 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are
     * closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    @JsonProperty("correct_option_id")
    private final Long correctOptionId;

    /**
     * <b>Optional.</b><br>
     * Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style
     * poll, 0-200 characters
     */
    @Size(max = 200)
    @JsonProperty("explanation")
    private final String explanation;

    /**
     * <b>Optional.</b><br>
     * Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    @Valid
    @JsonProperty("explanation_entities")
    private final List<MessageEntity> explanationEntities;

    /**
     * <b>Optional.</b><br>
     * Amount of time in seconds the poll will be active after creation
     */
    @JsonProperty("open_period")
    private final Long openPeriod;

    /**
     * <b>Optional.</b><br>
     * Point in time (Unix timestamp) when the poll will be automatically closed
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("close_date")
    private final Instant closeDate;

}
