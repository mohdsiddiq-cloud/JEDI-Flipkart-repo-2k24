package com.flipfit.exceptions;
public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}