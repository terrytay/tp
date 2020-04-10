package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SchedulableTaskDaysToFinishNotPositiveException extends CustomException {

    public static final String NUMBER_OF_DAYS_TO_FINISH_SHOULD_BE_GREATER_THAN_0 = "Number of days to finish should "
            + "be greater than 0";

    public SchedulableTaskDaysToFinishNotPositiveException() {
        super(NUMBER_OF_DAYS_TO_FINISH_SHOULD_BE_GREATER_THAN_0);
    }
}
