package atm.jobs;

import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.List;

public interface DepositJobInterface<T extends Cell> {

    int process(List<T> cells);

}
