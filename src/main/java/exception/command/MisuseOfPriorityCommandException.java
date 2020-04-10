package exception.command;

import exception.CustomException;

public class MisuseOfPriorityCommandException extends CustomException {

    public static final String INVALID_PRIORITY_VIEW_COMMAND = "Wrong command used to view events sorted "
            + "by priority (Should be :priority_view )";

    public MisuseOfPriorityCommandException() {
        super(INVALID_PRIORITY_VIEW_COMMAND);
    }
}