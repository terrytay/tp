package command;

import event.EventList;
import parser.Parser;
import ui.Ui;

import java.util.Scanner;

import static ui.Ui.BYE_COMMAND;

/**
 * Used to run all the functions related to events.
 */
public class EventCommand {

    /**
     * Runs all the command for events.
     *
     * @param eventList Refers to the current list of events.
     * @param ui UI object used to interact with user.
     * @param parser Object used to parse the user input into commands.
     */
    public void runCommands(EventList eventList, Ui ui, Parser parser) {
        eventList.printHelp();
        Scanner sc = new Scanner(System.in);
        String fullCommand;
        Command command;

        fullCommand = sc.nextLine();
        while (!fullCommand.equals(BYE_COMMAND)) {
            try {
                command = parser.parseCommand(fullCommand, ui);
                command.executeCommand(eventList);
            } catch (Exception exception) {
                ui.printLine();
                ui.printWithIndentation(exception.getMessage());
                ui.printLine();
            }
            ui.printEmptyLine();
            fullCommand = sc.nextLine();
        }
        ui.printByeMessage();
    }

}
