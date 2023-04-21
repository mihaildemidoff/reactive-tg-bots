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
 * Represents a link to an MP3 audio file. By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">InlineQueryResultAudio</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultAudio extends InlineQueryResult {

    /**
     * Type of the result, must be audio
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.AUDIO;

    /**
     * A valid file identifier for the audio file
     */
    @NotNull
    @JsonProperty("audio_url")
    private final String audioUrl;

    /**
     * Title
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
     * Performer
     */
    @JsonProperty("performer")
    private final String performer;

    /**
     * <b>Optional.</b><br>
     * Audio duration in seconds
     */
    @JsonProperty("audio_duration")
    private final Long audioDuration;

    /**
     * <b>Optional.</b><br>
     * Content of the message to be sent instead of the audio
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
