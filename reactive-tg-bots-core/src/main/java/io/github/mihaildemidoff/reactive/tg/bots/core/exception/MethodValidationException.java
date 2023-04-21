package io.github.mihaildemidoff.reactive.tg.bots.core.exception;

import lombok.Getter;

import java.util.List;

/**
 * Exception contains information about unsuccessful method validation.
 */
@Getter
public class MethodValidationException extends TelegramBotClientException {

    /**
     * List of validation violations
     */
    private final List<String> violations;

    /**
     * Constructor.
     *
     * @param violations list of validation violations in string format
     */
    public MethodValidationException(final List<String> violations) {
        this.violations = List.copyOf(violations);
    }

    /**
     * Constructor.
     *
     * @param violations list of validation violations in string format
     * @param message    the detail message.
     */
    public MethodValidationException(final String message,
                                     final List<String> violations) {
        super(message);
        this.violations = List.copyOf(violations);
    }

    /**
     * Constructor.
     *
     * @param violations list of validation violations in string format
     * @param message    the detail message.
     * @param cause      the cause.  (A {@code null} value is permitted,
     *                   and indicates that the cause is nonexistent or unknown.)
     */
    public MethodValidationException(final String message,
                                     final Throwable cause,
                                     final List<String> violations) {
        super(message, cause);
        this.violations = List.copyOf(violations);
    }

    /**
     * Constructor.
     *
     * @param violations list of validation violations in string format
     * @param cause      the cause.  (A {@code null} value is permitted,
     *                   and indicates that the cause is nonexistent or unknown.)
     */
    public MethodValidationException(final Throwable cause,
                                     final List<String> violations) {
        super(cause);
        this.violations = List.copyOf(violations);
    }

    /**
     * Constructor.
     *
     * @param violations         list of validation violations in string format
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public MethodValidationException(final String message,
                                     final Throwable cause,
                                     final boolean enableSuppression,
                                     final boolean writableStackTrace,
                                     final List<String> violations) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.violations = List.copyOf(violations);
    }
}
