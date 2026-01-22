package com.muni.muni_ecom.exception;

public class EmptyResourceException extends  RuntimeException{
    public EmptyResourceException() {
    }

    public EmptyResourceException(String message) {
        super(message);
    }
}
