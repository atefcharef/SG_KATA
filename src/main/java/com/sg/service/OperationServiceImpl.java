package com.sg.service;

import com.sg.entity.Account;
import com.sg.entity.Operation;

import java.util.List;

/**
 * the operation service implementation.
 *
 * @author ATEF
 */
public class OperationServiceImpl implements OperationService {


    @Override
    public List<Operation> getListOperationsByAccount(Account account) {
        return account.getOperations();
    }
}
