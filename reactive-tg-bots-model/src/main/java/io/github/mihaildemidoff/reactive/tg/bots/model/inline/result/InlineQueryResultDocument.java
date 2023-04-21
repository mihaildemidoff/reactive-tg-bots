package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.DocumentMimeType;
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
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">InlineQueryResultDocument</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultDocument extends InlineQueryResult {

    /**
     * Type of the result, must be document
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.DOCUMENT;


    /**
     * A valid file identifier for the file
     */
    @NotNull
    @JsonProperty("document_file_id")
    private final String documentFileId;

    /**
     * <b>Optional.</b><br>
     * Short description of the result
     */
    @JsonProperty("description")
    private final String description;

    /**
     * Title for the result
     */
    @NotNull
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Caption of the document to be sent, 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * <b>Optional.</b><br>
     * Mode for parsing entities in the document caption. See formatting options for more details.
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
     * A valid URL for the file
     */
    @NotNull
    @JsonProperty("document_url")
    private final String documentUrl;

    /**
     * MIME type of the content of the file, either “application/pdf” or “application/zip”
     */
    @NotNull
    @JsonProperty("mime_type")
    private final DocumentMimeType mimeType;

    /**
     * <b>Optional.</b><br>
     * Content of the message to be sent instead of the file
     */
    @Valid
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;

    /**
     * <b>Optional.</b><br>
     * URL of the thumbnail (JPEG only) for the file
     */
    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    /**
     * <b>Optional.</b><br>
     * Thumbnail width
     */
    @JsonProperty("thumbnail_width")
    private final Long thumbnailWidth;

    /**
     * <b>Optional.</b><br>
     * Thumbnail height
     */
    @JsonProperty("thumbnail_height")
    private final Long thumbnailHeight;
}
