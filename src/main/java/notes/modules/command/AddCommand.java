package notes.modules.command;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCommand extends Command {
    private String message;

    public AddCommand(String message) {
        this.message = message;
    }

    public void execute(ArrayList<String> messages) {
        messages.add(message);
    }

    public void unExecute() {

    }
}
