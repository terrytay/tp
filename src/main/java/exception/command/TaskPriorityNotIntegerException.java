package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class TaskPriorityNotIntegerException extends CustomException {

    public static final String PRIORITY_SHOULD_BE_AN_INTEGER = "Priority should be an integer";

    public TaskPriorityNotIntegerException() {
        super(PRIORITY_SHOULD_BE_AN_INTEGER);
    }
}