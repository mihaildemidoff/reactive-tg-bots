package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;

/**
 * Interface for methods that return boolean response.
 */
public interface BooleanBotMethodDefinition extends BaseBotMethodDefinition<Boolean> {

    /**
     * {@inheritDoc}
     */
    @Override
    default TypeReference<GenericBotApiResponse<Boolean>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

}
