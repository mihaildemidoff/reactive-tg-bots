package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.InputStream;

/**
 * This object represents the contents of a file to be uploaded. Must be posted using multipart/form-data in the usual way that files are uploaded via the browser.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputfile">InputFile</a>
 * @see <a href="https://core.telegram.org/bots/api#sending-files">Sending files</a>
 */
public interface InputFile {

    /**
     * Flag that input file should be send as multipart/form-data request
     *
     * @return true if file is multipart, otherwise false
     */
    @JsonIgnore
    default boolean isMultipart() {
        return false;
    }

    /**
     * File name of input file. Should be implemented if {@link InputFile#isMultipart()} is true
     *
     * @return file name
     */
    @JsonIgnore
    String getFileName();

    /**
     * Stream of input file. Should be implemented if {@link InputFile#isMultipart()} is true
     *
     * @return input file stream
     */
    @JsonIgnore
    InputStream getFileInputStream();

    /**
     * Mime type of input file. Should be implemented if {@link InputFile#isMultipart()} is true
     *
     * @return input file mime type
     */
    @JsonIgnore
    String getMimeType();

}
