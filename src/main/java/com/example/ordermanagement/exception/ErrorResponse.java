package com.example.ordermanagement.exception;

public record ErrorResponse (
        String message,
        String error,
        int status
    ) {
}
