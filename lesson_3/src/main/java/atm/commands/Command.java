package atm.commands;

import atm.AtmInterface;

import java.util.Scanner;

public abstract class Command {

    protected AtmInterface atmInterface;
    protected Scanner scanner;

    public Command(Scanner scanner, AtmInterface atmInterface) {
        this.atmInterface = atmInterface;
        this.scanner = scanner;
    }

    public abstract void execute();

    public abstract void printCommandInfo(int index);

}
