package exception.command;

import exception.CustomException;

import static ui.Ui.HELP_DESCRIPTION_3;

public class EventCreationFormatNotFollowedException extends CustomException {
    public EventCreationFormatNotFollowedException() {
        super("Please follow the correct format to add a new event\n" + HELP_DESCRIPTION_3);
    }
}