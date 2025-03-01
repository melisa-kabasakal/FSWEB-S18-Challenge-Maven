package com.workintech.fswebs18challengemaven.exceptions;

public class CardException extends RuntimeException {

    private Integer status;

    public CardException(String message) {
        super(message);
    }
}
