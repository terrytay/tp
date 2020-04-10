package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class IndexNotIntegerException extends CustomException {

    public static final String ENTER_VALID_INDEX = "Enter a valid integer index (1-based) to delete/edit/done the "
            + "corresponding event (format: delete/edit/done index)";

    public IndexNotIntegerException() {
        super(ENTER_VALID_INDEX);
    }
}