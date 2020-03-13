package command;

import event.EventList;
import exception.command.MisuseOfCountdownCommandException;
import ui.Ui;

/**
 * Displays the list of events added so far in increasing order of their dates.
 */
public class CountdownCommand extends Command {

    /**
     * Constructor for the CountdownCommand Object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public CountdownCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new MisuseOfCountdownCommandException();
        }
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) {
        eventList.countdownView(ui);
    }
}
