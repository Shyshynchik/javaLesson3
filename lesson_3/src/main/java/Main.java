import atm.commands.StartCommand;
import atm.storage.AtmCell;
import atm.storage.Banknote;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StartCommand startCommand = new StartCommand(List.of(
                new AtmCell(Banknote.ONE_THOUSAND, 1),
                new AtmCell(Banknote.FIVE_HUNDRED, 1),
                new AtmCell(Banknote.TWO_HUNDRED, 3),
                new AtmCell(Banknote.FIFTY, 0)
        ));

        startCommand.start();

    }

}
