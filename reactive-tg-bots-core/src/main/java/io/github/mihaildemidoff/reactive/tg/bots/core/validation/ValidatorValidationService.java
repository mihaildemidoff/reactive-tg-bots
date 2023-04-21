package io.github.mihaildemidoff.reactive.tg.bots.core.validation;

import io.github.mihaildemidoff.reactive.tg.bots.core.exception.MethodValidationException;
import io.github.mihaildemidoff.reactive.tg.bots.model.common.methoddefinition.BaseBotMethodDefinition;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JSR-380 base validation service
 */
@RequiredArgsConstructor
@Slf4j
public class ValidatorValidationService implements ValidationService {

    /**
     * JSR-380 validator
     */
    private final Validator validator;

    /**
     * {@inheritDoc}
     */
    @Override
    public <RESPONSE> void validateMethod(final BaseBotMethodDefinition<RESPONSE> method) {
        final Set<ConstraintViolation<BaseBotMethodDefinition<RESPONSE>>> validationResult = validator.validate(method);
        if (validationResult != null && !validationResult.isEmpty()) {
            final List<String> collectedErrors = validationResult.stream()
                    .map(violation -> String.format("%s value '%s' %s", violation.getPropertyPath(),
                            violation.getInvalidValue(), violation.getMessage()))
                    .collect(Collectors.toList());
            throw new MethodValidationException(String.format("Error occurred during method validation, errors: %s", String.join("\n", collectedErrors)), collectedErrors);
        }
    }

}

