package io.github.mihaildemidoff.reactive.tg.bots.model.file;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.BotApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;.
 * It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested
 * by calling getFile.
 * The maximum file size to download is 20 MB
 *
 * @see <a href="https://core.telegram.org/bots/api#file">File</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class File implements BotApiResponse {

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
     * <b>Optional.</b><br>
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer
     * or double-precision float type are safe for storing this value.
     */
    @NotNull
    @JsonProperty("file_size")
    private final Long fileSize;

    /**
     * <b>Optional.</b><br>
     * File path. Use https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt; to get the file.
     */
    @NotNull
    @JsonProperty("file_path")
    private final String filePath;
}
