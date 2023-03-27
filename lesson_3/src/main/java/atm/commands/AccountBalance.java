package atm.commands;

import atm.AtmInterface;

import java.util.Scanner;

public class AccountBalance extends Command{
    public AccountBalance(Scanner scanner, AtmInterface atmInterface) {
        super(scanner, atmInterface);
    }

    @Override
    public void execute() {
        if (atmInterface.isAccountActive()) {
            System.out.println(atmInterface.getAccountBalance());
            return;
        }

        System.out.println("Необходимо авторизироваться");
    }

    @Override
    public void printCommandInfo(int index) {
        System.out.println(index + ": Узнать баланс аккаунта");
    }
}
