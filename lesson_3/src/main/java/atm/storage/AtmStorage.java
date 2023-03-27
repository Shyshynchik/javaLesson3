package atm.storage;

import java.util.ArrayList;
import java.util.List;

public class AtmStorage<T extends Cell> implements Storage<T> {

    private final List<T> cells = new ArrayList<>();

    @Override
    public List<T> getCells() {
        return cells;
    }

    @Override
    public void add(T cell) {
        if (cells.contains(cell)) {
            cells.get(cells.indexOf(cell)).withdraw(cell.getCount());
            return;
        }
        cells.add(cell);
        sort();
    }

    @Override
    public void addAll(List<T> cells) {
        for (T cell: cells) {
            this.add(cell);
        }
    }

    private void sort() {
        cells.sort((c1, c2) -> c2.getBanknote().getNominal() - c1.getBanknote().getNominal());
    }
}
