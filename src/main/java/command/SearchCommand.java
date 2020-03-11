package command;

import event.EventList;
import ui.Ui;

/**
 * Command used to perform a search of events whose description contain the keyword mentioned.
 */
public class SearchCommand extends Command {

    /** The word to be searched for. */
    String keyword;

    /**
     * Constructor for SearchCommand object.
     * Creates a new object if the correct format is used.
     *
     * @param commandSplit Contains the keyword to be searched for.
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public SearchCommand(String[] commandSplit, boolean isOneWordCommand) throws Exception {
        if (isOneWordCommand) {
            throw new Exception("The search string entered is empty.");
        }
        this.keyword = commandSplit[1];
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) throws Exception {
        eventList.searchEvents(keyword, ui);
    }
}
