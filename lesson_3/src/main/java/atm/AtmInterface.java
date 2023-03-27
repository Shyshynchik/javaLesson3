package atm;

import atm.account.AccountInterface;
import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.List;

public interface AtmInterface {

    void login(AccountInterface account);
    boolean isAccountActive();
    int getAccountBalance();
    void logout();
    int atmBalance();
    void withdraw(int sum);
    void deposit(List<Cell> cells);

}
