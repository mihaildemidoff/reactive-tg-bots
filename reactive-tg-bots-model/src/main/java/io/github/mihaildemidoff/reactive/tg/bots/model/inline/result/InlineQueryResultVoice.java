package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * Represents a link to a voice recording in an .OGG container encoded with OPUS.
 * By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the voice
 * message.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvoice">InlineQueryResultVoice</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultVoice extends InlineQueryResult {

    /**
     * Type of the result, must be voice
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.VOICE;

    /**
     * A valid URL for the voice recording
     */
    @NotNull
    @JsonProperty("voice_url")
    private final String voiceUrl;

    /**
     * Recording title
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Caption, 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * <b>Optional.</b><br>
     * Mode for parsing entities in the audio caption. See formatting options for more details.
     */
    @JsonProperty("parse_mode")
    private final ParseMode parseMode;

    /**
     * <b>Optional.</b><br>
     * List of special entities that appear in the caption, which can be specified instead of parse_mode
     */
    @Valid
    @JsonProperty("caption_entities")
    private final List<MessageEntity> captionEntities;

    /**
     * <b>Optional.</b><br>
     * Recording duration in seconds
     */
    @NotNull
    @JsonProperty("voice_duration")
    private final Long voiceDuration;

    /**
     * <b>Optional.</b><br>
     * Content of the message to be sent instead of the voice recording
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
