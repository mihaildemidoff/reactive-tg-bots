package io.github.mihaildemidoff.reactive.tg.bots.model.file.input;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This object represents the contents of a file to be uploaded. Must be posted using multipart/form-data in the usual way that files are uploaded via the browser.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputfile">InputFile</a>
 */
public interface StreamedInputFile extends InputFile {

    /**
     * Value that will be set to request.
     *
     * @return json value of input file. attach://file_name by default
     */
    @JsonValue
    default String jsonValue() {
        return String.format("attach://%s", getFileName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean isMultipart() {
        return true;
    }
}
