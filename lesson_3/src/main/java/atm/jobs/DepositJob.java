package atm.jobs;

import atm.storage.AtmStorage;
import atm.storage.Cell;

import java.util.List;

public class DepositJob implements DepositJobInterface<Cell> {

    private final AtmStorage<Cell> localBank;

    public DepositJob(AtmStorage<Cell> atmStorage) {
        localBank = atmStorage;
    }
    @Override
    public int process(List<Cell> cells) {

        int sum = 0;

        for (Cell cell: cells) {
            Cell atmCell = localBank.getCells().get(localBank.getCells().indexOf(cell));

            sum += cell.getBanknote().getNominal() * cell.getCount();

            if (atmCell == null) {
                localBank.add(cell);
                continue;
            }

            atmCell.deposit(cell.getCount());
        }

        return sum;
    }
}
