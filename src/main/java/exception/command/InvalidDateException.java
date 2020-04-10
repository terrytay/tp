package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class InvalidDateException extends CustomException {

    public static final String INVALID_DATE = "Date provided is invalid or is in wrong format (Should be YYYY-MM-DD)";

    public InvalidDateException() {
        super(INVALID_DATE);
    }
}