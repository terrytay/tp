package exception.command;

import exception.CustomException;

public class MisuseOfViewCommandException extends CustomException {

    public static final String INVALID_VIEW_COMMAND = "Wrong command used to view events (Should be :view )";

    public MisuseOfViewCommandException() {
        super(INVALID_VIEW_COMMAND);
    }
}