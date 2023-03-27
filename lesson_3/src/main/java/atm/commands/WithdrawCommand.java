package atm.commands;

import atm.AtmInterface;

import java.util.Scanner;

public class WithdrawCommand extends Command {

    public WithdrawCommand(Scanner scanner, AtmInterface atmInterface) {
        super(scanner, atmInterface);
    }

    @Override
    public void execute() {
        System.out.println("Введите суммы для снятия");

        int sum = scanner.nextInt();

        atmInterface.withdraw(sum);
    }

    @Override
    public void printCommandInfo(int index) {
        System.out.println(index + ": Снять");
    }
}
