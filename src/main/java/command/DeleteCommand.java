package command;

import event.EventList;

/**
 * Command is used to delete an event at a specific index.
 */
public class DeleteCommand extends Command {

    /** Denotes the index at which the event should be deleted at. */
    int indexToDelete;

    /**
     * Constructor for the DeleteCommand object.
     * Creates a new object if the correct command is used.
     *
     * @param commandSplit Contains information with regards to the index to be deleted at.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the index specified is invalid/ The wrong format is used for the command.
     */
    public DeleteCommand(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        if (isOneWordCommand) {
            throw new Exception("Index to delete not mentioned");
        }
        try {
            indexToDelete = Integer.parseInt(commandSplit[1]);
        } catch (NumberFormatException e) {
            throw new Exception("Enter a valid integer index (1-based) to delete the corresponding event "
                    + "(format: delete index)");
        }
    }


    @Override
    public void executeCommand(EventList eventList) throws Exception {
        eventList.deleteEvent(indexToDelete, ui);
    }
}
