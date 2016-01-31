package com.mihailsergeevichs.imageboard.service.exception;

/**
 * Created by Overlord on 30.01.2016.
 */
public class BoardDoesNotExistsException extends RuntimeException {
    public BoardDoesNotExistsException() {
        super();
    }

    public BoardDoesNotExistsException(String message) {
        super(message);
    }

    public BoardDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardDoesNotExistsException(Throwable cause) {
        super(cause);
    }

    protected BoardDoesNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
