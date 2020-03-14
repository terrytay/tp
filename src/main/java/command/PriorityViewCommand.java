package command;

import event.EventList;
import exception.command.MisuseOfPriorityCommandException;
import ui.Ui;

/**
 * Displays the list of events added so far in decreasing order of their priority.
 */
public class PriorityViewCommand extends Command {

    /**
     * Constructor for the PriorityViewCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public PriorityViewCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfPriorityCommandException();
        }
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) {
        eventList.priorityView(ui);
    }
}
