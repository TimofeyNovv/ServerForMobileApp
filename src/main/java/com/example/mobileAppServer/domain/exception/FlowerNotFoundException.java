package com.example.mobileAppServer.domain.exception;

public class FlowerNotFoundException extends RuntimeException {
    public FlowerNotFoundException(String message) {
        super(message);
    }
}
