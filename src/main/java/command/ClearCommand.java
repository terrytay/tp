package command;

import event.EventList;
import exception.command.MisuseOfClearCommandException;
import ui.Ui;

/**
 * This command is used to clear all the events in the list.
 */
public class ClearCommand extends Command {

    /**
     * Constructor for the ClearCommand Object.
     * Checks if the user given input follows the correct format.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public ClearCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfClearCommandException();
        }
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) throws Exception {
        eventList.clearEvents(ui);
    }
}
