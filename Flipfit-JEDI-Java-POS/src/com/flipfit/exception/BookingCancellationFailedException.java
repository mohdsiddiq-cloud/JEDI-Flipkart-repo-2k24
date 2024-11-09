package com.flipfit.exception;

public class BookingCancellationFailedException extends Exception{
    @Override
    public String getMessage(){
        return "Booking cancellation failed. Please try again";
    }
}
