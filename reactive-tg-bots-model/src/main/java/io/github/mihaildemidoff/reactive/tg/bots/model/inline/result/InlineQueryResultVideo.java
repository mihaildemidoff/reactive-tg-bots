package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.VideoMimeType;
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
 * Represents a link to a page containing an embedded video player or a video file.
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 * If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you must replace its content using
 * input_message_content.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvideo">InlineQueryResultVideo</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultVideo extends InlineQueryResult {

    /**
     * Type of the result, must be video
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.VIDEO;

    /**
     * A valid URL for the embedded video player or video file
     */
    @NotNull
    @JsonProperty("video_url")
    private final String videoUrl;

    /**
     * MIME type of the content of the video URL, “text/html” or “video/mp4”
     */
    @NotNull
    @JsonProperty("mime_type")
    private final VideoMimeType mimeType;

    /**
     * URL of the thumbnail (JPEG only) for the video
     */
    @NotNull
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    /**
     * <b>Optional.</b><br>
     * Title for the result
     */
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Caption of the GIF file to be sent, 0-1024 characters after entities parsing
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
     * Video width
     */
    @JsonProperty("video_width")
    private final Long videoWidth;

    /**
     * <b>Optional.</b><br>
     * Video height
     */
    @JsonProperty("video_height")
    private final Long videoHeight;

    /**
     * <b>Optional.</b><br>
     * Video duration in seconds
     */
    @JsonProperty("video_duration")
    private final Long videoDuration;

    /**
     * <b>Optional.</b><br>
     * Short description of the result
     */
    @JsonProperty("description")
    private final String description;

    /**
     * <b>Optional.</b><br>
     * Content of the message to be sent instead of the video.
     * This field is required if InlineQueryResultVideo is used to send an HTML-page as a result (e.g.,a YouTube video).
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
