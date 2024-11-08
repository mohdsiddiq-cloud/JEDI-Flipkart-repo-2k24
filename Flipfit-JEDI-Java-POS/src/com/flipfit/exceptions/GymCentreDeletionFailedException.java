package com.flipfit.exceptions;

public class GymCentreDeletionFailedException extends Exception {
    public GymCentreDeletionFailedException(String message, Exception e) {
        super(message);
    }
}