package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class EmptyDescriptionException extends CustomException {

    public static final String DESCRIPTION_SHOULDN_T_BE_EMPTY = "Description shouldn't be empty";

    public EmptyDescriptionException() {
        super(DESCRIPTION_SHOULDN_T_BE_EMPTY);
    }
}