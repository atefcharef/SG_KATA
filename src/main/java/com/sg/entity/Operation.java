package com.sg.entity;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Operation contain list of operations that
 *
 * @author ATEF
 */
@Setter
@Getter
public class Operation {

    private Long OperationId;
    private LocalDateTime dateOperation;
    private BigDecimal amount;
    private BigDecimal balance;
    private OperationType operationType;

    public Operation(Long operationId, LocalDateTime dateOperation, BigDecimal balance, BigDecimal amount, OperationType operationType ) {
        OperationId = operationId;
        this.dateOperation = dateOperation;
        this.balance = balance;
        this.amount = amount;
        this.operationType = operationType;
    }

}
