package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationPriorityMissingException extends CustomException {

    public static final String PRIORITY_ENTERED_IS_EMPTY = "Priority entered is empty,"
            + " Please provide a valid priority value";

    public TaskCreationPriorityMissingException() {
        super(PRIORITY_ENTERED_IS_EMPTY);
    }
}
