package io.github.mihaildemidoff.reactive.tg.bots.model.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaanimation">InputMediaAnimation</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputMediaAnimation extends InputMedia {

    /**
     * Type of the result, must be animation
     */
    @NotNull
    @JsonProperty("type")
    private final InputMediaType type = InputMediaType.ANIMATION;

    /**
     * <b>Optional.</b><br>
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
     * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height
     * should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused
     * and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was
     * uploaded using multipart/form-data under &lt;file_attach_name&gt;.
     */
    @Valid
    @JsonProperty("thumbnail")
    private final InputFile thumbnail;

    /**
     * <b>Optional.</b><br>
     * Animation width
     */
    @JsonProperty("width")
    private final Long width;

    /**
     * <b>Optional.</b><br>
     * Animation height
     */
    @JsonProperty("height")
    private final Long height;

    /**
     * <b>Optional.</b><br>
     * Animation duration in seconds
     */
    @JsonProperty("duration")
    private final Long duration;

    /**
     * <b>Optional.</b><br>
     * Pass True if the Animation needs to be covered with a spoiler animation
     */
    @JsonProperty("has_spoiler")
    private final Boolean hasSpoiler;

    @Override
    public List<InputFile> getInputFiles() {
        return Stream
                .of(getMedia(), thumbnail)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
