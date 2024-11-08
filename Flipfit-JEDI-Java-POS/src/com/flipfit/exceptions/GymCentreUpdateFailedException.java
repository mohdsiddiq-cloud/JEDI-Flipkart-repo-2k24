package com.flipfit.exceptions;

public class GymCentreUpdateFailedException extends Exception {
    public GymCentreUpdateFailedException(String message, Exception e) {
        super(message);
    }
}