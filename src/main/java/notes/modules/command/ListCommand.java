package notes.modules.command;

import ui.Constants;
import ui.Ui;
import java.util.ArrayList;

//@@author terrytay
public class ListCommand implements Command {
    private static Ui ui;
    private ArrayList<String> messages;

    public ListCommand(ArrayList<String> messages, Ui ui) {
        this.messages = messages;
    }

    /**
     * Displays the notes in the module.
     */
    public void execute() {

        if (messages.isEmpty()) {
            ui.printOut(Constants.NO_NOTES_YET, true);
        } else {
            for (String message : messages) {
                ui.printOut(message, false);
                ui.printEmptyLine();
            }
            ui.printLine();
        }
    }

    public void undo() {

    }

    public void redo() {

    }
}
