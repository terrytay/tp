package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class TaskCreationDescriptionMissingException extends CustomException {

    public static final String DESCRIPTION_IS_EMPTY = "Description entered is empty, Please provide a "
            + "valid description";

    public TaskCreationDescriptionMissingException() {
        super(DESCRIPTION_IS_EMPTY);
    }
}
