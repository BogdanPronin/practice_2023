package com.example.demo.impl.exception;

public class TicketNotAvailableException extends RuntimeException {
    public TicketNotAvailableException(String message) {
        super(message);
    }
}
