package atm.jobs;

import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.List;

public interface WithdrawJobInterface<T extends Cell> {

    List<Banknote> process(int sum);

}
