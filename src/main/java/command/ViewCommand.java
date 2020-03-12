package command;

import event.EventList;
import exception.command.MisuseOfViewCommandException;
import ui.Ui;

/**
 * Displays the list of events added so far.
 */
public class ViewCommand extends Command {

    /**
     * Constructor for the ViewCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public ViewCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfViewCommandException();
        }
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) {
        eventList.listEvents(ui);
    }
}
