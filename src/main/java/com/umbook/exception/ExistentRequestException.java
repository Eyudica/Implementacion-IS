package com.umbook.exception;

public class ExistentRequestException extends RuntimeException {
    public ExistentRequestException(String message) {
        super(message);
    }
}