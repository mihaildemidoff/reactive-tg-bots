package io.github.mihaildemidoff.reactive.tg.bots.model.validation;

import io.github.mihaildemidoff.reactive.tg.bots.model.passport.errors.PassportElementErrorSectionType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validate that enum value is in subset.
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PassportElementErrorSectionTypeSubsetValidator.class)
public @interface PassportElementErrorSectionTypeSubset {

    /**
     * List of allowed enum values.
     *
     * @return allowed enum values
     */
    PassportElementErrorSectionType[] anyOf();

    /**
     * Violation message
     *
     * @return message
     */
    String message() default "must be any of {anyOf}";

    /**
     * List of validation groups
     *
     * @return validation groups
     */
    Class<?>[] groups() default {};

    /**
     * List of payloads
     *
     * @return list of payloads
     */
    Class<? extends Payload>[] payload() default {};

}
