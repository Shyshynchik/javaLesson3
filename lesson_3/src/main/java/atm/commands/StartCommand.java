package atm.commands;

import atm.ATM;
import atm.AtmInterface;
import atm.storage.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartCommand {

    private final AtmInterface atmInterface;

    private final Scanner scanner;

    private final List<Command> commands = new ArrayList<>();

    public StartCommand(List<Cell> cells) {
        this.atmInterface = new ATM(cells);
        this.scanner = new Scanner(System.in);

        initCommands();
    }

    private void initCommands() {
        commands.add(new AccountCommand(scanner, atmInterface));
        commands.add(new AtmBalanceCommand(scanner, atmInterface));
        commands.add(new AccountBalance(scanner, atmInterface));
        commands.add(new WithdrawCommand(scanner, atmInterface));
        commands.add(new DepositCommand(scanner, atmInterface));
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Command command : commands) {
                command.printCommandInfo(commands.indexOf(command));
            }

            int command = scanner.nextInt();

            commands.get(command).execute();

        }
    }
}
