package io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.GenericBotApiResponse;

/**
 * Interface for methods with media payload that return boolean response.
 */
public interface BooleanBotMediaMethodDefinition extends BaseBotMediaMethodDefinition<Boolean> {

    /**
     * {@inheritDoc}
     */
    @Override
    default TypeReference<GenericBotApiResponse<Boolean>> getResponseClass() {
        return new TypeReference<>() {
        };
    }

}
