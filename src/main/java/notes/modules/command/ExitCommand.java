package notes.modules.command;

import java.util.ArrayList;

public class ExitCommand extends Command {

    public void execute(ArrayList<String> messages) {

    }

    /**
     * Implemented from https://github.com/se-edu/addressbook-level2/
     * blob/master/src/seedu/addressbook/commands/ExitCommand.java.
     * To check if command is exit command.
     * @param command the command parsed
     * @return true if command parsed is exit command
     */
    public static boolean isExit(Command command) {
        return command instanceof ExitCommand;
    }
}
