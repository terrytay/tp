package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DeadlineDetailsNotProvidedException extends CustomException {

    public static final String DEADLINE_DETAILS_ARE_NOT_PROVIDED = "Deadline details are not provided";

    public DeadlineDetailsNotProvidedException() {
        super(DEADLINE_DETAILS_ARE_NOT_PROVIDED);
    }
}
