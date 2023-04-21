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
 * This object represents a voice note.
 *
 * @see <a href="https://core.telegram.org/bots/api#voice">Voice</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Voice {

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

}
