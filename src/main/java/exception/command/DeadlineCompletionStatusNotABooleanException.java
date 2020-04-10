package exception.command;

import exception.CustomException;
import ui.Constants;

//@@author GanapathySanathBalaji
public class DeadlineCompletionStatusNotABooleanException extends CustomException {

    public DeadlineCompletionStatusNotABooleanException() {
        super(Constants.COMPLETION_STATUS_ERROR_MESSAGE);
    }
}