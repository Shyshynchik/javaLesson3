package atm.account;

public class Account implements AccountInterface {

    private int balance;
    public Account(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void withdraw(int sum) {
        balance -= sum;
    }

    @Override
    public void deposit(int sum) {
        balance += sum;
    }
}
