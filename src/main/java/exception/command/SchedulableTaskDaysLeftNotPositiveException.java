package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysLeftNotPositiveException extends CustomException {

    public static final String NUMBER_OF_DAYS_LEFT_SHOULD_BE_GREATER_THAN_0 = "Number of days left should be greater"
            + " than 0";

    public SchedulableTaskDaysLeftNotPositiveException() {
        super(NUMBER_OF_DAYS_LEFT_SHOULD_BE_GREATER_THAN_0);
    }
}
