package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class InvalidDueTimeException extends CustomException {

    public static final String INVALID_DUE_TIME = "Due time provided is invalid or in wrong format (Should be HH:MM)"
            + " 24 Hr format";

    public InvalidDueTimeException() {
        super(INVALID_DUE_TIME);
    }
}