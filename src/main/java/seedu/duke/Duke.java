package seedu.duke;

import command.Command;
import driver.Driver;
import event.EventList;
import parser.Parser;
import ui.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ui.Ui.BYE_COMMAND;


public class Duke {

    private static Ui ui = new Ui();
    private static Parser parser = new Parser();

    /**
     * Main entry-point for the java.duke.Duke application.
     * @param args Commandline argument
     * @throws Exception If error is found during execution.
     */
    public static void main(String[] args) throws Exception {
        ui.printWelcomeMessage();

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        /**
         * To run:
         * events: enter 1
         * study areas: enter 0
         * To end events loop: enter bye in events prog
         * To end study areas loop: enter end in study area loop
         * To end overall prog, enter ctrl+c or ctrl+z or enter any string of letters.
         * Take note: this is still temporary
         */
        while (true) {
            Scanner mode = new Scanner(System.in);
            try {
                Driver driver = new Driver(mode.nextInt(), ui, parser);
            } catch (NumberFormatException | InputMismatchException e) {
                break;
            }
        }
    }

}
