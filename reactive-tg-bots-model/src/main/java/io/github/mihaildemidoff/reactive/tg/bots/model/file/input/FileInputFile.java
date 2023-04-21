package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Input file represented by file.
 *
 * @see <a href="https://core.telegram.org/bots/api#sending-files">Sending files</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileInputFile implements StreamedInputFile {

    /**
     * File
     */
    @JsonIgnore
    @NotNull
    private final File file;

    /**
     * File name
     */
    @NotNull
    @JsonIgnore
    private final String fileName;

    /**
     * File mime type
     */
    @JsonIgnore
    private final String mimeType;

    /**
     * {@inheritDoc}
     */
    @Override
    @SneakyThrows
    public InputStream getFileInputStream() {
        return new FileInputStream(file);
    }

}
