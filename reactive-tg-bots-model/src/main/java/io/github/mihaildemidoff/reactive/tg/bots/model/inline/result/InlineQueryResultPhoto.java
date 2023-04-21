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
 * Represents a link to a photo. By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultphoto">InlineQueryResultPhoto</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultPhoto extends InlineQueryResult {

    /**
     * Type of the result, must be photo
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.PHOTO;

    /**
     * A valid URL of the photo. Photo must be in JPEG format. Photo size must not exceed 5MB
     */
    @NotNull
    @JsonProperty("photo_url")
    private final String photoUrl;

    /**
     * URL of the thumbnail for the photo
     */
    @NotNull
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    /**
     * <b>Optional.</b><br>
     * Width of the photo
     */
    @JsonProperty("photo_width")
    private final Long photoWidth;

    /**
     * <b>Optional.</b><br>
     * Height of the photo
     */
    @JsonProperty("photo_height")
    private final Long photoHeight;


    /**
     * <b>Optional.</b><br>
     * Title for the result
     */
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Short description of the result
     */
    @JsonProperty("description")
    private final String description;

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
     * Content of the message to be sent instead of the photo
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
