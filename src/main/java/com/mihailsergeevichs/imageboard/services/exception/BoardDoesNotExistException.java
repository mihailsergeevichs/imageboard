package com.mihailsergeevichs.imageboard.services.exception;

/**
 * Created by Overlord on 31.01.2016.
 */
public class BoardDoesNotExistException extends RuntimeException {
    public BoardDoesNotExistException() {
    }

    public BoardDoesNotExistException(String message) {
        super(message);
    }

    public BoardDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public BoardDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
