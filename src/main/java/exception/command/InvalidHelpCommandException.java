package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class InvalidHelpCommandException extends CustomException {

    public static final String INVALID_CALL_TO_HELP_COMMAND = "Wrong command used to view command "
            + "list (Should be :help )";

    public InvalidHelpCommandException() {
        super(INVALID_CALL_TO_HELP_COMMAND);
    }
}