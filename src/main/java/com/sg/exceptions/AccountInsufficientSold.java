package com.sg.exceptions;


/**
 * the exception must be thrown when trying to withdraw when
 * account has insufficient sold.
 *
 * @author ATEF
 */
public class AccountInsufficientSold extends AccountExceptions {

    public AccountInsufficientSold() {
        super("sold insufficient to authorise the operation");
    }

    public AccountInsufficientSold(String message) {
        super(message);
    }
}
