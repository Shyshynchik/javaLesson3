package atm.commands;

import atm.AtmInterface;

import java.util.Scanner;

public class AtmBalanceCommand extends Command {
    public AtmBalanceCommand(Scanner scanner, AtmInterface atmInterface) {
        super(scanner, atmInterface);
    }

    @Override
    public void execute() {
        System.out.println(atmInterface.atmBalance());
    }

    @Override
    public void printCommandInfo(int index) {
        System.out.println(index + ": Узнать баланс банкомата");
    }
}
