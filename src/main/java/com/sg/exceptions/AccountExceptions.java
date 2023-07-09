package com.sg.exceptions;


/**
 * the Account class exception
 * @author ATEF
 */
public class AccountExceptions extends RuntimeException {

    private final String message;


    public AccountExceptions(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
