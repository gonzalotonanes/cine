package com.cine.domain.exceptions;

public class NotCapacityException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotCapacityException(String message) {
        super(message);
    }

    public NotCapacityException() {
    }
}
