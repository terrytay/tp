package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class EventStartTimeAfterEndTimeException extends CustomException {

    public static final String START_TIME_SHOULD_BE_BEFORE_END_TIME = "Start time should be before End time";

    public EventStartTimeAfterEndTimeException() {
        super(START_TIME_SHOULD_BE_BEFORE_END_TIME);
    }
}