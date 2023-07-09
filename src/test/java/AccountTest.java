import com.sg.entity.Account;
import com.sg.exceptions.AccountInsufficientSold;
import com.sg.exceptions.AmountNegativeValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author ATEF
 */
public class AccountTest {

    private Account account;


    @Before
    public void setUp() {
        this.account = new Account(1L, new BigDecimal(0), new ArrayList<>());
    }

    @Test
    public void shouldSuccessDepositAmount() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(2000);

        //WHEN
        account.deposit(amount);

        //THEN
        Assert.assertEquals(account.getBalance(), BigDecimal.valueOf(2000));
    }

    @Test(expected = AmountNegativeValue.class)
    public void shouldFailDepositWhenAmountIsNegative() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(-2000);

        //WHEN
        account.deposit(amount);
    }

    @Test
    public void shouldSuccessWithDrawAccount() {

        // GIVEN
        BigDecimal amount = BigDecimal.valueOf(1000);
        account.deposit(BigDecimal.valueOf(5000));

        //WHEN
        account.withDraw(amount);

        //THEN
        Assert.assertEquals(account.getBalance(), BigDecimal.valueOf(4000));
    }


    @Test(expected = AmountNegativeValue.class)
    public void shouldFailWithdrawWhenAmountIsNegative() {

        //GIVEN
        BigDecimal amount = BigDecimal.valueOf(-2000);

        //WHEN
        account.withDraw(amount);
    }

    @Test(expected = AccountInsufficientSold.class)
    public void shouldFailWithDrawInsufficientBalance() {

        //GIVEN
        BigDecimal amount = BigDecimal.valueOf(2000);
        account.deposit(BigDecimal.valueOf(500));

        //WHEN
        account.withDraw(amount);
    }

}
