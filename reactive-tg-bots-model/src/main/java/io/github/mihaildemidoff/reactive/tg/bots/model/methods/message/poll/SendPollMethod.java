package io.github.mihaildemidoff.reactive.tg.bots.model.methods.message.poll;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BotMethod;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.TypedBotMethodDefinition;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantDeserializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.jackson.InstantSerializer;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.Message;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import io.github.mihaildemidoff.reactive.tg.bots.model.poll.PollType;
import io.github.mihaildemidoff.reactive.tg.bots.model.reply.ReplyMarkup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
 * Use this method to send a native poll.
 * On success, the sent {@link Message} is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendpoll">sendPoll</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendPollMethod implements TypedBotMethodDefinition<Message> {

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    @NotNull
    @JsonProperty("message_id")
    private final String messageId;

    /**
     * Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     */
    @JsonProperty("message_thread_id")
    private final Long messageThreadId;

    /**
     * Poll question, 1-300 characters
     */
    @NotNull
    @JsonProperty("question")
    private final String question;

    /**
     * A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
     */
    @Size(min = 2, max = 10)
    @Valid
    @NotNull
    @JsonProperty("options")
    private final List<@Size(min = 1, max = 100) String> options;


    /**
     * True, if the poll needs to be anonymous, defaults to True
     */
    @JsonProperty("is_anonymous")
    private final Boolean isAnonymous;

    /**
     * Poll type, “quiz” or “regular”, defaults to “regular”
     */
    @JsonProperty("type")
    private final PollType type;

    /**
     * True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to False
     */
    @JsonProperty("allows_multiple_answers")
    private final Boolean allowsMultipleAnswers;

    /**
     * 0-based identifier of the correct answer option, required for polls in quiz mode
     */
    @JsonProperty("correct_option_id")
    private final Long correctOptionId;

    /**
     * Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll,
     * 0-200 characters with at most 2 line feeds after entities parsing
     */
    @JsonProperty("explanation")
    private final String explanation;

    /**
     * Mode for parsing entities in the explanation. See formatting options for more details.
     */
    @JsonProperty("explanation_parse_mode")
    private final ParseMode explanationParseMode;

    /**
     * A JSON-serialized list of special entities that appear in the poll explanation, which can be specified instead
     * of parse_mode
     */
    @Valid
    @JsonProperty("explanation_entities")
    private final List<MessageEntity> explanationEntities;

    /**
     * Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with close_date.
     */
    @Max(600)
    @Min(5)
    @JsonProperty("open_period")
    private final Long openPeriod;

    /**
     * Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than
     * 600 seconds in the future. Can't be used together with open_period.
     */
    @NotNull
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("close_date")
    private final Instant closeDate;

    /**
     * Pass True if the poll needs to be immediately closed. This can be useful for poll preview.
     */
    @NotNull
    @JsonProperty("is_closed")
    private final Boolean isClosed;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    private final Boolean disableNotification;

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    @JsonProperty("protect_content")
    private final Boolean protectContent;

    /**
     * If the message is a reply, ID of the original message
     */
    @JsonProperty("reply_to_message_id")
    private final Long replyToMessageId;

    /**
     * Pass True if the message should be sent even if the specified replied-to message is not found
     */
    @JsonProperty("allow_sending_without_reply")
    private final Boolean allowSendingWithoutReply;

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard,
     * instructions to remove reply keyboard or to force a reply from the user.
     */
    @JsonProperty("reply_markup")
    private final ReplyMarkup replyMarkup;

    @Override
    public TypeReference<GenericBotApiResponse<Message>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

    @Override
    public BotMethod getMethod() {
        return BotMethod.SEND_POLL;
    }
}
