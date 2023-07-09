package com.sg.service;

import com.sg.entity.Account;
import com.sg.entity.Operation;

import java.util.List;

public interface OperationService {

    /**
     * get the list of operations by account.
     *
     * @param account the current account
     * @return {@link List} of {@link Operation}
     */
    List<Operation> getListOperationsByAccount(Account account);

}
