package com.mihailsergeevichs.imageboard.services.exception;

/**
 * Created by Overlord on 31.01.2016.
 */
public class BoardAlreadyExistedException extends RuntimeException {
    public BoardAlreadyExistedException() {
    }

    public BoardAlreadyExistedException(String message) {
        super(message);
    }

    public BoardAlreadyExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardAlreadyExistedException(Throwable cause) {
        super(cause);
    }

    public BoardAlreadyExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
