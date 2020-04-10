package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class EventDetailsNotProvidedException extends CustomException {

    public static final String EVENT_DETAILS_ARE_NOT_PROVIDED = "Event details are not provided";

    public EventDetailsNotProvidedException() {
        super(EVENT_DETAILS_ARE_NOT_PROVIDED);
    }
}
