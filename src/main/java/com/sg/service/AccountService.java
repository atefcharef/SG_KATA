package com.sg.service;

import com.sg.entity.Account;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * the deposit operation.
     *
     * @param account the account
     * @param amount the amount
     * @return the current {@link Account}
     */
    Account deposit(Account account, BigDecimal amount);


    /**
     * the withdrawal operation.
     *
     * @param account the account
     * @param amount the amount
     * @return the current {@link Account}
     */
    Account withDraw(Account account, BigDecimal amount);
}
