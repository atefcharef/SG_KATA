package com.sg;

import com.sg.entity.Account;
import com.sg.service.AccountService;
import com.sg.service.AccountServiceImpl;
import com.sg.service.OperationService;
import com.sg.service.OperationServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

public class sgApplication {

    public static void main(String[] args) {

        Account account = new Account(1L, new BigDecimal(1000), new ArrayList<>());

        AccountService accountService = new AccountServiceImpl();
        OperationService operationService = new OperationServiceImpl();

        accountService.deposit(account, new BigDecimal(1000));
        accountService.withDraw(account, new BigDecimal(100));
        operationService.getListOperationsByAccount(account).forEach(operation -> System.out.println(operation.toString()));

    }
}
