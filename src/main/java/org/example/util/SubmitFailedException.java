package org.example.util;

public class SubmitFailedException extends RuntimeException {
    public SubmitFailedException(String message) {
        super(message);
    }
}
