package io.github.mihaildemidoff.reactive.tg.bots.model.validation;

import io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors.PassportElementErrorSectionType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

/**
 * Validator for {@link PassportElementErrorSectionTypeSubset}
 */
public class PassportElementErrorSectionTypeSubsetValidator
        implements ConstraintValidator<PassportElementErrorSectionTypeSubset, PassportElementErrorSectionType> {

    /**
     * Value of anyOf
     */
    private PassportElementErrorSectionType[] subset;

    @Override
    public void initialize(final PassportElementErrorSectionTypeSubset constraintAnnotation) {
        subset = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(final PassportElementErrorSectionType value,
                           final ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
