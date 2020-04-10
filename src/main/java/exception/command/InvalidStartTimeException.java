package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class InvalidStartTimeException extends CustomException {

    public static final String INVALID_START_TIME = "Start time provided is invalid or in wrong format "
            + "(Should be HH:MM) 24 Hr format";

    public InvalidStartTimeException() {
        super(INVALID_START_TIME);
    }
}