package com.flipfit.exceptions;

public class FlipFitBusinessException extends Exception {
    public FlipFitBusinessException(String message) {
        super(message);
    }

    public FlipFitBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}