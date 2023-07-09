package com.sg.service;

import com.sg.entity.Account;
import com.sg.entity.Operation;

import java.util.List;

public interface OperationService {

    List<Operation> getListOperationsByAccount(Account account);

}
