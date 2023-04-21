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
 * Represents an audio file to be treated as music to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaaudio">InputMediaAudio</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputMediaAudio extends InputMedia {

    /**
     * Type of the result, must be audio
     */
    @NotNull
    @JsonProperty("type")
    private final InputMediaType type = InputMediaType.AUDIO;

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
     * Duration of the audio in seconds
     */
    @JsonProperty("duration")
    private final Long duration;

    /**
     * <b>Optional.</b><br>
     * Performer of the audio
     */
    @JsonProperty("performer")
    private final String performer;

    /**
     * <b>Optional.</b><br>
     * Title of the audio
     */
    @JsonProperty("title")
    private final String title;

    @Override
    public List<InputFile> getInputFiles() {
        return Stream
                .of(getMedia(), thumbnail)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
