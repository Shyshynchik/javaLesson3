package atm.commands;

import atm.AtmInterface;
import atm.storage.AtmCell;
import atm.storage.Banknote;
import atm.storage.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepositCommand extends Command {
    public DepositCommand(Scanner scanner, AtmInterface atmInterface) {
        super(scanner, atmInterface);
    }

    @Override
    public void execute() {
        printBanknotesInfo();

        String sum = scanner.nextLine();

        List<Cell> cells = parseStringForCells(sum);

        atmInterface.deposit(cells);
    }

    @Override
    public void printCommandInfo(int index) {
        System.out.println(index + ": Внести");
    }

    private void printBanknotesInfo() {
        System.out.println("Введите номинал и количество в формате banknote-count");

        for (Banknote banknote: Banknote.values()) {
            System.out.print(banknote.getNominal() + " ");
        }

        System.out.println();
    }

    private List<Cell> parseStringForCells(String str) {
        List<Cell> cells = new ArrayList<>();

        String[] rawCells = str.split(" ");

        for (String rawCell: rawCells) {
            String[] rawCellData = rawCell.split("-");

            int nominal = Integer.parseInt(rawCellData[0]);
            int count = Integer.parseInt(rawCellData[1]);

            Banknote banknote = Banknote.getValueByNominal(nominal);

            if (banknote == null) {
                System.out.println("Неправильно введеный номинал");
                cells = null;
                break;
            }

            cells.add(new AtmCell(banknote, count));
        }

        return cells;
    }
}
