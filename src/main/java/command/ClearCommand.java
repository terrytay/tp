package command;

import event.EventList;

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
            throw new Exception("Wrong command clear events (Should be :clear )");
        }
    }

    @Override
    public void executeCommand(EventList eventList) throws Exception {
        eventList.clearEvents(ui);
    }
}
