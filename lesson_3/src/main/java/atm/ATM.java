package atm;

import atm.account.AccountInterface;
import atm.jobs.DepositJob;
import atm.jobs.DepositJobInterface;
import atm.jobs.WithdrawJob;
import atm.jobs.WithdrawJobInterface;
import atm.storage.AtmStorage;
import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.List;

public class ATM implements AtmInterface {

    private final AtmStorage<Cell> localBank = new AtmStorage<>();
    private final WithdrawJobInterface<Cell> withdrawJob;
    private final DepositJobInterface<Cell> depositJob;
    private AccountInterface account;

    public ATM(List<Cell> cells) {
        localBank.addAll(cells);
        withdrawJob = new WithdrawJob(localBank);
        depositJob = new DepositJob(localBank);
    }

    public void login(AccountInterface account) {
        this.account = account;
    }

    @Override
    public boolean isAccountActive() {
        return account != null;
    }

    @Override
    public int getAccountBalance() {
        return account.getBalance();
    }

    @Override
    public void logout() {
        account = null;
    }

    public int atmBalance() {
        int sum = 0;

        for (Cell cell: localBank.getCells()) {
            sum += cell.getBanknote().getNominal() * cell.getCount();
        }

        return sum;
    }

    public void withdraw(int sum) {
        if (!isAccountActive()) {
            return;
        }

        if (account.getBalance() < sum) {
            System.out.println("Недостаточно средств");
            return;
        }

        List<Banknote> list = withdrawJob.process(sum);

        if (list != null) {
            account.withdraw(sum);
        }
    }

    @Override
    public void deposit(List<Cell> cells) {
        if (!isAccountActive()) {
            return;
        }

        int sum = depositJob.process(cells);

        account.deposit(sum);
    }
}
