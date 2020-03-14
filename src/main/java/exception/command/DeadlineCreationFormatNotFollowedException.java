package exception.command;

import exception.CustomException;

import static ui.Ui.HELP_DESCRIPTION_5;

public class DeadlineCreationFormatNotFollowedException extends CustomException {
    public DeadlineCreationFormatNotFollowedException() {
        super("Please follow the correct format to add a new deadline\n" + HELP_DESCRIPTION_5);
    }
}