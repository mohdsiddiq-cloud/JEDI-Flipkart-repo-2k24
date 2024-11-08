package com.flipfit.exceptions;

public class FlipFitLoginException extends Exception {
    public FlipFitLoginException(String message) {
        super(message);
    }

    public FlipFitLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}