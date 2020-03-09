package ui;

/**
 * Contains functions used to interact with the user.
 */
public class Ui {

    /**
     * Prints a line made up of '_'.
     */
    public void printLine() {
        System.out.println("____________________________________________________________________________________");
    }

    public void printWithIndentation(String line) {
        System.out.println("    " + line);
    }

    public void printHelp() {
        printLine();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        printLine();
    }

    public void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
    }
}
