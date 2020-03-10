package seedu.duke;

import driver.Driver;
import ui.Ui;

import java.util.Scanner;


public class Duke {

    private static Ui ui = new Ui();

    /**
     * Main entry-point for the java.duke.Duke application.
     * @param args
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
         * To end overall prog, enter ctrl+c or ctrl+z
         * Take note: this is still temporary
         */
        while (true) {
            Scanner mode = new Scanner(System.in);
            Driver driver = new Driver(mode.nextInt());
        }
    }
}
