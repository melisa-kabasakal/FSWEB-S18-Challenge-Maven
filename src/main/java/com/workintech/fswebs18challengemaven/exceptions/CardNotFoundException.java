package com.workintech.fswebs18challengemaven.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;



@Getter
@Setter
public class CardNotFoundException extends RuntimeException {
    private String expectedMessage;
    private HttpStatus httpStatus;

    public CardNotFoundException(String expectedMessage) {
        super(expectedMessage);
        this.expectedMessage = expectedMessage;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
    public CardNotFoundException(String expectedMessage, HttpStatus httpStatus) {
        super(expectedMessage);
        this.expectedMessage = expectedMessage;
        this.httpStatus = httpStatus;
    }
}

