package notes.modules.command;

import java.util.ArrayList;

public class ListCommand extends Command {

    /**
     * Displays the notes in the module.
     * @param messages notes in the module
     */
    public void execute(ArrayList<String> messages) {
        System.out.println("______________________________");
        if (messages.isEmpty()) {
            System.out.println("No notes have been added for this module yet.");
        }
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println("______________________________");
    }
}
