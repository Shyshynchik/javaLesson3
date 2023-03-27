package atm;

import atm.account.Account;
import atm.storage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AtmTest {

    private AtmInterface atm;

    @BeforeEach
    public void setUpLocalBank() {
        atm = new ATM(List.of(
                new AtmCell(Banknote.ONE_THOUSAND, 1),
                new AtmCell(Banknote.FIVE_HUNDRED, 1),
                new AtmCell(Banknote.TWO_HUNDRED, 3),
                new AtmCell(Banknote.FIFTY, 0)
        ));

        atm.login(new Account(1700));
    }

    @Test
    public void testWithdraw() {
        atm.withdraw(1600);
        Assertions.assertEquals(500, atm.atmBalance());
        atm.withdraw(650);
        Assertions.assertEquals(500, atm.atmBalance());
    }

    @Test
    public void testWithdrawCycle() {
        atm.withdraw(50);
        Assertions.assertEquals(2100, atm.atmBalance());
    }

    @Test
    public void testDeposit() {
        atm.deposit(List.of(
                new AtmCell(Banknote.ONE_THOUSAND, 2),
                new AtmCell(Banknote.FIVE_HUNDRED, 3)
        ));

        Assertions.assertEquals(5600, atm.atmBalance());
        Assertions.assertEquals(5200, atm.getAccountBalance());
    }

}
