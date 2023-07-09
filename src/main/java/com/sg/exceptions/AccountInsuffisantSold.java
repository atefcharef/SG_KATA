package com.sg.exceptions;


/**
 * the expception must be thrown when trying to withdraw when
 * account has insufficient sold
 * @author ATEF
 */
public class AccountInsuffisantSold extends AccountExceptions {

    public AccountInsuffisantSold() {
        super("sold insufficient to authorise the operation");
    }

    public AccountInsuffisantSold(String message) {
        super(message);
    }
}
