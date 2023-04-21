package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.InputStream;

/**
 * InputStream input file.
 *
 * @see <a href="https://core.telegram.org/bots/api#sending-files">Sending files</a>
 */
@Valid
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputStreamInputFile implements StreamedInputFile {

    /**
     * File input stream.
     */
    @JsonIgnore
    @NotNull
    private final InputStream inputStream;

    /**
     * File name
     */
    @JsonIgnore
    @NotNull
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
    public InputStream getFileInputStream() {
        return inputStream;
    }
}
