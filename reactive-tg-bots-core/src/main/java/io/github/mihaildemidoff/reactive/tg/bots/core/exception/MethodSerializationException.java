package io.github.mihaildemidoff.reactive.tg.bots.core.exception;

import lombok.Getter;

/**
 * Exception describing unsuccessful method serialization.
 */
@Getter
public class MethodSerializationException extends TelegramBotClientException {

    /**
     * Constructor.
     */
    public MethodSerializationException() {
    }

    /**
     * Constructor.
     *
     * @param message the detail message.
     */
    public MethodSerializationException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message the detail message.
     * @param cause   the cause.  (A {@code null} value is permitted,
     *                and indicates that the cause is nonexistent or unknown.)
     */
    public MethodSerializationException(final String message,
                                        final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     *
     * @param cause the cause.  (A {@code null} value is permitted,
     *              and indicates that the cause is nonexistent or unknown.)
     */
    public MethodSerializationException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public MethodSerializationException(final String message,
                                        final Throwable cause,
                                        final boolean enableSuppression,
                                        final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
