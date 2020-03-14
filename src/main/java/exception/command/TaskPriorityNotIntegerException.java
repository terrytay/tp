package exception.command;

import exception.CustomException;

import static ui.Ui.HELP_DESCRIPTION_5;

public class TaskPriorityNotIntegerException extends CustomException {
    public TaskPriorityNotIntegerException() {
        super("Priority should be an integer");
    }
}