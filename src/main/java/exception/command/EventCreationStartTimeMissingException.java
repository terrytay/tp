package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji

public class EventCreationStartTimeMissingException extends CustomException {

    public static final String START_TIME_ENTERED_IS_EMPTY_PLEASE_PROVIDE_A_VALID_START_TIME = "Start time entered is"
            + " empty, Please provide a valid start time";

    public EventCreationStartTimeMissingException() {
        super(START_TIME_ENTERED_IS_EMPTY_PLEASE_PROVIDE_A_VALID_START_TIME);
    }
}
