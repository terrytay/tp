package notes.modules.command;

import ui.Constants;

import java.util.LinkedList;

//@@author terrytay
public class CommandStack {
    /**
     * Adapted from: https://www.developer.com/design
     * /article.php/3720566/Working-With-Design-Patterns-Memento.htm
     */
    private LinkedList<Command> commandStack
            = new LinkedList<>();
    private LinkedList<Command> redoStack
            = new LinkedList<>();

    /**
     * Execute the given command, and add it to a undo stack and redo stack.
     * @param command command parsed
     */
    public void execute(Command command) {
        command.execute();
        commandStack.addFirst(command);
        redoStack.clear();
    }

    /**
     * Undo a command.
     */
    public void undo() {
        if (commandStack.isEmpty()) {
            System.out.println(Constants.NOTHING_TO_UNDO);
            return;
        }
        Command command = commandStack.removeFirst();
        command.undo();
        redoStack.addFirst(command);
    }

    /**
     * Redo a command.
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println(Constants.NOTHING_TO_REDO);
            return;
        }
        Command command = redoStack.removeFirst();
        command.redo();
        commandStack.addFirst(command);
    }
}
