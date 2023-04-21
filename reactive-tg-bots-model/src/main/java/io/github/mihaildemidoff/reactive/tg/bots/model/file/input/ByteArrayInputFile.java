package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Byte array input file. Will be sent by multipart/form-data
 *
 * @see <a href="https://core.telegram.org/bots/api#sending-files">Sending files</a>
 */
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ByteArrayInputFile implements StreamedInputFile {

    /**
     * File name.
     */
    @JsonIgnore
    @NotNull
    @JsonValue
    private final String fileName;

    /**
     * Byte array payload.
     */
    @NotEmpty
    @JsonIgnore
    @NotNull
    private final byte[] bytes;

    /**
     * File mime type.
     */
    @JsonIgnore
    private final String mimeType;

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getFileInputStream() {
        return new ByteArrayInputStream(bytes);
    }
}
