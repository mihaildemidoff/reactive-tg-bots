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
 * This object represents one size of a photo or a file / sticker thumbnail.
 *
 * @see <a href="https://core.telegram.org/bots/api#photosize">PhotoSize</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoSize {
    /**
     * dentifier for this file, which can be used to download or reuse the file
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
     * Photo width
     */
    @NotNull
    @JsonProperty("width")
    private final Long width;

    /**
     * Photo height
     */
    @NotNull
    @JsonProperty("height")
    private final Long height;

    /**
     * <b>Optional.</b><br>
     * File size in bytes
     */
    @JsonProperty("file_size")
    private final Long fileSize;

}
