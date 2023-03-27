package atm.storage;

import java.util.Objects;

public class AtmCell implements Cell {

    private final Banknote banknote;
    private int count;

    public AtmCell(Banknote banknote, int count) {
        this.banknote = banknote;
        this.count = count;
    }

    @Override
    public Banknote getBanknote() {
        return banknote;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void deposit(int count) {
        this.count += count;
    }

    @Override
    public void withdraw(int count) {
        this.count -= count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtmCell cell = (AtmCell) o;
        return banknote == cell.banknote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(banknote);
    }
}
