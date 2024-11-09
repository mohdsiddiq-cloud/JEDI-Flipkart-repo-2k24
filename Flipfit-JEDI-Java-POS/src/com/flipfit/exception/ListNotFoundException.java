package com.flipfit.exception;

public class ListNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "List not found.";
    }
}
