package exception.command;

import exception.CustomException;

public class MisuseOfCountdownCommandException extends CustomException {

    public static final String INVALID_COUNTDOWN_COMMAND = "Wrong command used to view countdown of events"
            + " (Should be :countdown )";

    public MisuseOfCountdownCommandException() {
        super(INVALID_COUNTDOWN_COMMAND);
    }
}
