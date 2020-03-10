package command;

import event.EventList;

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
            throw new Exception("Wrong command used to view events sorted by priority (Should be :priority_view )");
        }
    }

    @Override
    public void executeCommand(EventList eventList) throws Exception {
        eventList.priorityView(ui);
    }
}
