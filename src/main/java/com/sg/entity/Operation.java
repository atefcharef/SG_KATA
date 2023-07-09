package com.sg.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Operation contain list of operations that
 *
 * @author ATEF
 */
@Setter
@Getter
@ToString
public class Operation {

    private Long operationId;
    private LocalDateTime dateOperation;
    private BigDecimal amount;
    private BigDecimal balance;
    private OperationType operationType;

    /**
     *
     * @param operationId the operation id
     * @param dateOperation the date of the transaction
     * @param balance the balance by operation
     * @param amount the amount of the operation
     * @param operationType the type of operation {@link OperationType}
     */
    public Operation(Long operationId, LocalDateTime dateOperation, BigDecimal balance, BigDecimal amount, OperationType operationType ) {
        this.operationId = operationId;
        this.dateOperation = dateOperation;
        this.balance = balance;
        this.amount = amount;
        this.operationType = operationType;
    }

}
