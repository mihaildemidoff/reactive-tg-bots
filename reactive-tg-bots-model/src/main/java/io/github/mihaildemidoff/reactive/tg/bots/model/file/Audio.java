package io.github.mihaildemidoff.reactive.tg.bots.model.file;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 *
 * @see <a href="https://core.telegram.org/bots/api#audio">Audio</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio {

    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    @NotNull
    @JsonProperty("file_id")
    private final String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @NotNull
    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    /**
     * Duration of the audio in seconds as defined by sender
     */
    @NotNull
    @JsonProperty("duration")
    private final Long duration;

    /**
     * <b>Optional.</b><br>
     * Performer of the audio as defined by sender or by audio tags
     */
    @JsonProperty("performer")
    private final String performer;

    /**
     * <b>Optional.</b><br>
     * Title of the audio as defined by sender or by audio tags
     */
    @JsonProperty("title")
    private final String title;

    /**
     * <b>Optional.</b><br>
     * Original filename as defined by sender
     */
    @JsonProperty("file_name")
    private final String fileName;

    /**
     * <b>Optional.</b><br>
     * MIME type of the file as defined by sender
     */
    @JsonProperty("mime_type")
    private final String mimeType;

    /**
     * <b>Optional.</b><br>
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects
     * in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float
     * type are safe for storing this value.
     */
    @JsonProperty("file_size")
    private final Long fileSize;

    /**
     * <b>Optional.</b><br>
     * Thumbnail of the album cover to which the music file belongs
     */
    @JsonProperty("thumbnail")
    private final PhotoSize thumbnail;

}
