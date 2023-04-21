package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.InputStream;

/**
 * Input file represented by file_id
 *
 * @see <a href="https://core.telegram.org/bots/api#sending-files">Sending files</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileIdInputFile implements InputFile {

    /**
     * Telegram file id.
     */
    @JsonValue
    @NotNull
    private final String fileId;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileName() {
        throw new UnsupportedOperationException("There is no file name FileIdInput");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getFileInputStream() {
        throw new UnsupportedOperationException("There is no file for FileIdInput");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMimeType() {
        throw new UnsupportedOperationException("There is no mime type for FileIdInput");
    }
}
