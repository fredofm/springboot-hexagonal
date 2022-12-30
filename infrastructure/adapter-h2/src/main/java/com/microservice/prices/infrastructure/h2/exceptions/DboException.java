package com.microservice.prices.infrastructure.h2.exceptions;

public class DboException extends RuntimeException {
    public DboException(String message) {
        super(message);
    }

    public DboException(String format, Object... objects) {
        super(String.format(format, objects));
    }
}
