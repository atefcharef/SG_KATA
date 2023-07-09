package com.sg.exceptions;

/**
 * the amount negative exception.
 *
 * @author ATEF
 */
public class AmountNegativeValue extends AccountExceptions {

    public AmountNegativeValue() {
        super("the amount should be positive to continue the deposit operation");
    }

    public AmountNegativeValue(String message) {
        super(message);
    }
}
