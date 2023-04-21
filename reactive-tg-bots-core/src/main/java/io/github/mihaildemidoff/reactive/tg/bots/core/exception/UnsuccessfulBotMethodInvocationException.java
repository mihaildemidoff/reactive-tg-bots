package io.github.mihaildemidoff.reactive.tg.bots.core.exception;

import lombok.Getter;

/**
 * Exception describing unsuccessful bot method execution.
 * Will be thrown when telegram responds with ok=false.
 */
@Getter
public class UnsuccessfulBotMethodInvocationException extends TelegramBotClientException {

    /**
     * Error code returned by telegram server.
     */
    private final Long errorCode;

    /**
     * error description returned by telegram
     */
    private final String description;

    /**
     * Constructor.
     *
     * @param errorCode   error code returned by telegram server
     * @param description error description returned by telegram
     */
    public UnsuccessfulBotMethodInvocationException(final Long errorCode,
                                                    final String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Constructor.
     *
     * @param errorCode   error code returned by telegram server
     * @param description error description returned by telegram
     * @param message     the detail message.
     */
    public UnsuccessfulBotMethodInvocationException(final String message,
                                                    final Long errorCode,
                                                    final String description) {
        super(message);
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Constructor.
     *
     * @param errorCode   error code returned by telegram server
     * @param description error description returned by telegram
     * @param message     the detail message.
     * @param cause       the cause.  (A {@code null} value is permitted,
     *                    and indicates that the cause is nonexistent or unknown.)
     */
    public UnsuccessfulBotMethodInvocationException(final String message,
                                                    final Throwable cause,
                                                    final Long errorCode,
                                                    final String description) {
        super(message, cause);
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Constructor.
     *
     * @param errorCode   error code returned by telegram server
     * @param description error description returned by telegram
     * @param cause       the cause.  (A {@code null} value is permitted,
     *                    and indicates that the cause is nonexistent or unknown.)
     */
    public UnsuccessfulBotMethodInvocationException(final Throwable cause,
                                                    final Long errorCode,
                                                    final String description) {
        super(cause);
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Constructor.
     *
     * @param errorCode          error code returned by telegram server
     * @param description        error description returned by telegram
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public UnsuccessfulBotMethodInvocationException(final String message,
                                                    final Throwable cause,
                                                    final boolean enableSuppression,
                                                    final boolean writableStackTrace,
                                                    final Long errorCode,
                                                    final String description) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.description = description;
    }
}
