package service;

import com.sg.entity.Account;
import com.sg.exceptions.AccountInsufficientSold;
import com.sg.exceptions.AmountNegativeValue;
import com.sg.service.AccountService;
import com.sg.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountServiceTest {

    Account account;

    AccountService accountService;

    @Before
    public void setUp() {
        this.account = new Account(1L, new BigDecimal(0), new ArrayList<>());
        this.accountService = new AccountServiceImpl();
    }

    @Test
    public void shouldSuccessDepositAmount() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(2000);

        //WHEN
        accountService.deposit(account, amount);

        //THEN
        Assert.assertEquals(account.getBalance(), BigDecimal.valueOf(2000));
    }

    @Test(expected = AmountNegativeValue.class)
    public void shouldFailDepositWhenAmountIsNegative() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(-2000);

        //WHEN
        accountService.deposit(account, amount);
    }

    @Test
    public void shouldSuccessWithDrawAccount() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(1000);
        accountService.deposit(account, BigDecimal.valueOf(5000));

        //WHEN
        accountService.withDraw(account, amount);

        //THEN
        Assert.assertEquals(account.getBalance(), BigDecimal.valueOf(4000));
    }


    @Test(expected = AmountNegativeValue.class)
    public void shouldFailWithdrawWhenAmountIsNegative() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(-2000);

        //WHEN
        accountService.withDraw(account, amount);
    }

    @Test(expected = AccountInsufficientSold.class)
    public void shouldFailWithDrawInsufficientBalance() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(2000);
        accountService.deposit(account, BigDecimal.valueOf(500));

        //WHEN
        accountService.withDraw(account, amount);
    }

}
