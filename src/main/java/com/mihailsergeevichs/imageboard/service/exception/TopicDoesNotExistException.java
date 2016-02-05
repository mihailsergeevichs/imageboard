package com.mihailsergeevichs.imageboard.service.exception;

/**
 * Created by Overlord on 01.02.2016.
 */
public class TopicDoesNotExistException extends RuntimeException {
    public TopicDoesNotExistException() {
    }

    public TopicDoesNotExistException(String message) {
        super(message);
    }

    public TopicDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public TopicDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
