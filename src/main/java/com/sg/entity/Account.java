package com.sg.entity;


import com.sg.exceptions.AccountInsuffisantSold;
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

    public Account deposit(BigDecimal amount) {

        this.balance = balance.add(amount);
        this.operations.add(new Operation(1L, LocalDateTime.now(), balance, amount, OperationType.DEPOSIT));
        return this;
    }

    public Account withDraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
        checkTransactionAmountNegativity(amount);
        this.operations.add(new Operation(1L, LocalDateTime.now(), balance, amount, OperationType.WITHDRAW));
        return this;
    }

    private static void checkTransactionAmountNegativity(BigDecimal transactionAmount) {
        if (transactionAmount.compareTo(BigDecimal.ZERO) <= 0) throw new AccountInsuffisantSold();
    }

}