package command;

import event.EventList;
import parser.Parser;
import ui.Ui;
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
    public static void runCommands(EventList eventList, Ui ui, Parser parser) {
        ui.printHelp();
        String fullCommand;
        Command command;

        fullCommand = ui.getUserIn();
        while (!fullCommand.equals(BYE_COMMAND)) {
            try {
                command = parser.parseCommand(fullCommand);
                command.executeCommand(eventList, ui);
            } catch (Exception exception) {
                ui.printLine();
                ui.printMessage(exception.getMessage());
                ui.printLine();
            }
            fullCommand = ui.getUserIn();

        }
        ui.printLine();
        ui.printMessage(Ui.BYE_MESSAGE);
        ui.printLine();
    }

}
