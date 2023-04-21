package io.github.mihaildemidoff.reactive.tg.bots.model.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a photo to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaphoto">InputMediaPhoto</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputMediaPhoto extends InputMedia {

    /**
     * Type of the result, must be photo
     */
    @NotNull
    @JsonProperty("type")
    private final InputMediaType type = InputMediaType.PHOTO;

    /**
     * <b>Optional.</b><br>
     * Pass True if the photo needs to be covered with a spoiler animation
     */
    @JsonProperty("has_spoiler")
    private final Boolean hasSpoiler;

    @Override
    public List<InputFile> getInputFiles() {
        return Stream.ofNullable(getMedia())
                .collect(Collectors.toList());
    }
}
