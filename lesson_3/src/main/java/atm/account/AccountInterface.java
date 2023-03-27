package atm.account;

public interface AccountInterface {

    int getBalance();

    void withdraw(int sum);

    void deposit(int sum);

}
