package com.wipro.cepfreteservice.exception;

public class InvalidCepFormatException extends RuntimeException {
    public InvalidCepFormatException(String message) {
        super(message);
    }
}
