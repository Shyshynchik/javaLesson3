package atm.commands;

import atm.AtmInterface;
import atm.account.Account;
import atm.account.AccountInterface;
import atm.account.Accounts;

import java.util.Scanner;

public class AccountCommand extends Command {
    public AccountCommand(Scanner scanner, AtmInterface atmInterface) {
        super(scanner, atmInterface);
    }

    @Override
    public void execute() {
        if (atmInterface.isAccountActive()) {
            atmInterface.logout();
            return;
        }

        System.out.println("Введите логин:");
        String login = scanner.nextLine();

        AccountInterface account = Accounts.getAccount(login);

        if (account == null) {
            System.out.println("Неправильный логин");
            return;
        }

        atmInterface.login(account);
    }

    @Override
    public void printCommandInfo(int index) {
        if (atmInterface.isAccountActive()) {
            System.out.println(index + ": Выйти");
            return;
        }
        System.out.println(index + ": Войти");
    }
}
