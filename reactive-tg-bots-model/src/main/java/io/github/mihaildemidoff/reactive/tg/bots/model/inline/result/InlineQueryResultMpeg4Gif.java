package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.ThumbnailMimeType;
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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * By default, this animated MPEG-4 file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the
 * animation.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultmpeg4gif">InlineQueryResultMpeg4Gif</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {

    /**
     * Type of the result, must be mpeg4_gif
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.MPEG4_GIF;

    /**
     * A valid URL for the MPEG4 file. File size must not exceed 1MB
     */
    @NotNull
    @JsonProperty("mpeg4_url")
    private final String mpeg4Url;

    /**
     * <b>Optional.</b><br>
     * Video width
     */
    @JsonProperty("mpeg4_width")
    private final Long mpeg4Width;

    /**
     * <b>Optional.</b><br>
     * Video height
     */
    @JsonProperty("mpeg4_height")
    private final Long mpeg4Height;

    /**
     * <b>Optional.</b><br>
     * Video duration in seconds
     */
    @JsonProperty("mpeg4_duration")
    private final Long mpeg4Duration;

    /**
     * URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     */
    @NotNull
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    /**
     * <b>Optional.</b><br>
     * MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”.
     * Defaults to “image/jpeg”
     */
    @JsonProperty("thumbnail_mime_type")
    private final ThumbnailMimeType thumbnailMimeType;

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
     * Content of the message to be sent instead of the video animation
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
