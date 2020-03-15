package exception.command;

import exception.CustomException;

import static ui.Ui.HELP_DESCRIPTION_5;

public class EventStartTimeAfterEndTimeException extends CustomException {
    public EventStartTimeAfterEndTimeException() {
        super("Start time should be before End time");
    }
}