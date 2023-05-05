package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.mihaildemidoff.reactive.tg.bots.model.file.input.InputFile;

import java.util.List;
import java.util.Optional;

/**
 * Interface-marker. All telegram methods with media payload should implement this class.
 *
 * @param <RESPONSE> response type, that telegram returns in the 'result' field
 */
public interface BaseBotMediaMethodDefinition<RESPONSE> extends BaseBotMethodDefinition<RESPONSE> {

    /**
     * Get all input files of methods.
     * Method should return ALL input files including all nested objects.
     *
     * @return method input files
     */
    @JsonIgnore
    List<InputFile> getAllInputFiles();

    /**
     * {@inheritDoc}
     */
    @JsonIgnore
    default boolean isMultipartMethod() {
        return Optional.ofNullable(getAllInputFiles())
                .orElse(List.of())
                .stream()
                .anyMatch(InputFile::isMultipart);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default boolean isMediaMethod() {
        return true;
    }
}
