package com.flipfit.exceptions;

public class BookingConflictException extends Exception {
    public BookingConflictException(String message) {
        super(message);
    }
}