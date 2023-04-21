package io.github.mihaildemidoff.reactive.tg.bots.core.validation;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;

/**
 * Base interface for validation service.
 */
public interface ValidationService {

    /**
     * Validate telegram method request.
     * If method is invalid method should throw
     * {@link io.github.mihaildemidoff.reactive.tg.bots.core.exception.MethodValidationException}
     *
     * @param method     method to validate
     * @param <RESPONSE> generic type of method response
     */
    <RESPONSE> void validateMethod(BaseBotMethodDefinition<RESPONSE> method);
}
