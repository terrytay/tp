package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class NumberOfTasksToBeScheduledNotAnIntegerException extends CustomException {

    public static final String NUMBER_OF_TASKS_TO_BE_SCHEDULED_AS_MENTIONED_IS_NOT_AN_INTEGER = "Number of tasks to be "
            + "scheduled as mentioned is not an integer";

    public NumberOfTasksToBeScheduledNotAnIntegerException() {
        super(NUMBER_OF_TASKS_TO_BE_SCHEDULED_AS_MENTIONED_IS_NOT_AN_INTEGER);
    }
}