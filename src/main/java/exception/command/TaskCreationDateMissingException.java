package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationDateMissingException extends CustomException {

    public static final String DATE_ENTERED_IS_EMPTY = "Date entered is empty, Please provide a valid date";

    public TaskCreationDateMissingException() {
        super(DATE_ENTERED_IS_EMPTY);
    }
}
