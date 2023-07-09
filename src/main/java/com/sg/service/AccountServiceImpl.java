package com.sg.service;

import com.sg.entity.Account;

import java.math.BigDecimal;


/**
 * the account service.
 *
 * @author ATEF
 */
public class AccountServiceImpl implements AccountService {

    public Account deposit(Account account, BigDecimal amount) {
        return account.deposit(amount);
    }

    public Account withDraw(Account account, BigDecimal amount) {
        return account.withDraw(amount);
    }
}
