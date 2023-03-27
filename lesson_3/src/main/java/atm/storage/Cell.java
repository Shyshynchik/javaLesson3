package atm.storage;

public interface Cell {
    Banknote getBanknote();
    int getCount();
    void withdraw(int count);
    void deposit(int count);
}
