package exception.command;

import exception.CustomException;

public class MisuseOfSetDoneWithEvent extends CustomException {

    public static final String INVALID_DONE_COMMAND = "Task of event type cannot be marked as done";

    public MisuseOfSetDoneWithEvent() {
        super(INVALID_DONE_COMMAND);
    }
}
