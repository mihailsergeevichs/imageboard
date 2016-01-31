package com.mihailsergeevichs.imageboard.services.exception;

/**
 * Created by Overlord on 31.01.2016.
 */
public class TopicAlreadyExistedException extends RuntimeException {
    public TopicAlreadyExistedException() {
    }

    public TopicAlreadyExistedException(String message) {
        super(message);
    }

    public TopicAlreadyExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicAlreadyExistedException(Throwable cause) {
        super(cause);
    }

    public TopicAlreadyExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
