package io.github.mihaildemidoff.reactive.tg.bots.model.inline.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.content.InputMessageContent;
import io.github.mihaildemidoff.reactive.tg.bots.model.inline.types.InlineQueryResultType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a link to an article or web page.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultarticle">InlineQueryResultArticle</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineQueryResultArticle extends InlineQueryResult {

    /**
     * Type of the result, must be article
     */
    @NotNull
    @JsonProperty("type")
    private final InlineQueryResultType type = InlineQueryResultType.ARTICLE;

    /**
     * Title of the result
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
     * URL of the result
     */
    @JsonProperty("url")
    private final String url;

    /**
     * <b>Optional.</b><br>
     * Pass True if you don't want the URL to be shown in the message
     */
    @JsonProperty("hide_url")
    private final Boolean hideUrl;

    /**
     * <b>Optional.</b><br>
     * Short description of the result
     */
    @JsonProperty("description")
    private final String description;

    /**
     * <b>Optional.</b><br>
     * Url of the thumbnail for the result
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

    /**
     * Content of the message to be sent
     */
    @Valid
    @NotNull
    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;


}
