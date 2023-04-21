package io.github.mihaildemidoff.reactive.tg.bots.model.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.mihaildemidoff.reactive.tg.bots.model.enums.ParseMode;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import io.github.mihaildemidoff.reactive.tg.bots.model.message.MessageEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * This object represents the content of a media message to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmedia">InputMedia</a>
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InputMediaAnimation.class, name = "animation"),
        @JsonSubTypes.Type(value = InputMediaAudio.class, name = "audio"),
        @JsonSubTypes.Type(value = InputMediaDocument.class, name = "document"),
        @JsonSubTypes.Type(value = InputMediaPhoto.class, name = "photo"),
        @JsonSubTypes.Type(value = InputMediaVideo.class, name = "video")
})
@SuperBuilder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class InputMedia {

    /**
     * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL
     * for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one
     * using multipart/form-data under &lt;file_attach_name&gt; name.
     */
    @Valid
    @NotNull
    @JsonProperty("media")
    private final InputFile media;

    /**
     * <b>Optional.</b><br>
     * Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    @JsonProperty("caption")
    private final String caption;

    /**
     * <b>Optional.</b><br>
     * Mode for parsing entities in the caption. See formatting options for more details.
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
     * Returns type of input media
     *
     * @return input media type
     */
    public abstract InputMediaType getType();

    /**
     * Returns all input files of object.
     *
     * @return all input files of object
     */
    @JsonIgnore
    public abstract List<InputFile> getInputFiles();

}
