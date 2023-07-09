package com.sg.service;

import com.sg.entity.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account deposit(Account account, BigDecimal amount);

    Account withDraw(Account account, BigDecimal amount);
}
