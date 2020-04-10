package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysLeftNotIntegerException extends CustomException {

    public static final String NUMBER_OF_DAYS_LEFT_SHOULD_BE_AN_INTEGER = "Number of days left should be an integer";

    public SchedulableTaskDaysLeftNotIntegerException() {
        super(NUMBER_OF_DAYS_LEFT_SHOULD_BE_AN_INTEGER);
    }
}