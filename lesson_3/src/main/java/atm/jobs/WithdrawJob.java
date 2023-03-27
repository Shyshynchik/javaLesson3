package atm.jobs;

import atm.storage.AtmCell;
import atm.storage.AtmStorage;
import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.ArrayList;
import java.util.List;

public class WithdrawJob implements WithdrawJobInterface<Cell> {

    private final AtmStorage<Cell> localBank;
    private List<Integer> indexes = new ArrayList<>();
    private List<Cell> result = new ArrayList<>();
    public WithdrawJob(AtmStorage<Cell> atmStorage) {
        localBank = atmStorage;
    }

    private int canselLastStep() {
        var lastEl = result.get(result.size() - 1);
        lastEl.withdraw(1);
        if (lastEl.getCount() == 0) {
            result.remove(result.size() - 1);
        }
        return lastEl.getBanknote().getNominal();
    }

    private int getLastIndex() {
        return indexes.remove(indexes.size() - 1);
    }

    private List<Cell> withdraw(int sum) {

        int index = 0;

        int lastIndex = indexes.isEmpty() ? -1 : getLastIndex();

        for (Cell cell : localBank.getCells()) {
            if (index < lastIndex + 1) {
                index++;
                continue;
            }
            int count = sum / cell.getBanknote().getNominal();
            int drawCount = Math.min(count, cell.getCount());

            if (drawCount == 0) {
                index++;
                continue;
            }

            result.add(new AtmCell(cell.getBanknote(), drawCount));

            sum -= cell.getBanknote().getNominal() * drawCount;

            indexes.add(index++);

            if (sum == 0) {
                break;
            }
        }

        if (sum > 0) {
            return indexes.isEmpty() ? null : withdraw(sum + canselLastStep());
        }

        return result;
    }

    @Override
    public List<Banknote> process(int sum) {
        this.indexes = new ArrayList<>();
        this.result = new ArrayList<>();

        withdraw(sum);
        
        return commitChanges(result);
    }

    private List<Banknote> commitChanges(List<Cell> cells) {

        List<Banknote> banknotes = new ArrayList<>();

        for (Cell cell: cells) {
            banknotes.add(cell.getBanknote());
            Cell atmCell = localBank.getCells().get(localBank.getCells().indexOf(cell));
            atmCell.withdraw(cell.getCount());
        }

        return banknotes;
    }
}
