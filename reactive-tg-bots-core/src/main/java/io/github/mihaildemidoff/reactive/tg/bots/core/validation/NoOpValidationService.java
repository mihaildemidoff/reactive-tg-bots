package io.github.mihaildemidoff.reactive.tg.bots.core.validation;

import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;

/**
 * Empty validation service.
 */
public class NoOpValidationService implements ValidationService {

    /**
     * Method does nothing.
     *
     * @param method     method to validate
     * @param <RESPONSE> generic type of method response
     */
    @Override
    public <RESPONSE> void validateMethod(final BaseBotMethodDefinition<RESPONSE> method) {
        // do nothing
    }
}
