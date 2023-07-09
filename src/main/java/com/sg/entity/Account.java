package com.sg.entity;


import com.sg.exceptions.AccountInsufficientSold;
import com.sg.exceptions.AmountNegativeValue;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Account class definition
 *
 * @author ATEF
 */
@Getter
@Setter
public class Account {

    private Long idAccount;
    private BigDecimal balance;
    private List<Operation> operations;

    public Account(Long idAccount, BigDecimal balance, List<Operation> operations) {
        this.idAccount = idAccount;
        this.balance = balance;
        this.operations = operations;
    }

    /**
     * deposit amount in account.
     *
     * @param amount the amount to be deposited
     * @return the current account {@link Account}
     */
    public Account deposit(BigDecimal amount) {

        this.balance = balance.add(amount);
        checkAmountValue(amount);
        this.operations.add(new Operation(1L, LocalDateTime.now(), balance, amount, OperationType.DEPOSIT));
        return this;
    }

    /**
     * withDraw amount from account.
     *
     * @param amount to be withdrawn
     * @return the current account {@link Account}
     */
    public Account withDraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
        checkAmountValue(amount);
        checkTransactionAmountNegativity(this);
        this.operations.add(new Operation(1L, LocalDateTime.now(), balance, amount, OperationType.WITHDRAW));
        return this;
    }

    /**
     * check the withdrawal operation before.
     *
     * @param account the current account
     * @throws {@link AccountInsufficientSold}
     */
    private static void checkTransactionAmountNegativity(Account account) {
        if (account.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
            throw new AccountInsufficientSold();
        }
    }

    /**
     * check the Amount Value.
     *
     * @param amount the amount
     */
    private static void checkAmountValue(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new AmountNegativeValue();
        }
    }

}