package service;

import com.sg.entity.Account;
import com.sg.service.AccountService;
import com.sg.service.AccountServiceImpl;
import com.sg.service.OperationService;
import com.sg.service.OperationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OperationServiceTest {


    Account account;

    OperationService operationService;

    AccountService accountService;

    @Before
    public void setUp() {
        this.account = new Account(1L, new BigDecimal(0), new ArrayList<>());
        this.operationService = new OperationServiceImpl();
        this.accountService = new AccountServiceImpl();
    }

    @Test
    public void shouldReturnListOfOperationsByAccount() {

        accountService.deposit(account, new BigDecimal(1000));
        accountService.withDraw(account, new BigDecimal(100));
        accountService.withDraw(account, new BigDecimal(500));

        operationService.getListOperationsByAccount(account).forEach(System.out::println);

        Assert.assertEquals(operationService.getListOperationsByAccount(account).size(), 3);
    }

}
