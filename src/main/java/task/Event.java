package task;

import exception.command.EventStartTimeAfterEndTimeException;
import exception.command.InvalidDateException;
import exception.command.InvalidEndTimeException;
import exception.command.InvalidStartTimeException;
import exception.command.SearchKeywordEmptyException;
import exception.command.TaskDateBeforeCurrentDateException;
import exception.command.TaskPriorityNotIntegerException;
import ui.Ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an event and contains the related functions.
 */
public class Event extends Task {

    public static final int EDIT_DESCRIPTION = 1;
    public static final int EDIT_DATE = 2;
    public static final int EDIT_START_TIME = 3;
    public static final int EDIT_END_TIME = 4;
    public static final int EDIT_PRIORITY = 5;
    public static final String ERROR_MESSAGE = "Error encountered during execution";
    public static final String DATE_PATTERN = "MMM d yyyy";
    public static final String EVENT_SYMBOL = "[E] ";
    public static final String AT = " at ";
    public static final String FROM = " from ";
    public static final String TO = " to ";
    public static final String WITH_PRIORITY = " with priority ";
    public static final String EMPTY_STRING = "";
    public static final String DELIMITER = "#";
    public static final String NEW_LINE_CHARACTER = "\n";
    public static final String EVENT_IDENTIFIER = "E";
    public static final String ENTER_NEW_PRIORITY_MESSAGE = "Enter new priority:";
    public static final String ENTER_NEW_END_TIME_MESSAGE = "Enter new End Time:";
    public static final String ENTER_NEW_START_TIME_MESSAGE = "Enter new Start Time:";
    public static final String ENTER_NEW_DATE_MESSAGE = "Enter new Date:";
    public static final String ENTER_NEW_DESCRIPTION_MESSAGE = "Enter new description:";
    public static final String ENTER_VALID_NUMBER_FROM_LIST_MESSAGE = "Please enter a valid number from the list";
    public static final String UPDATED_DETAILS = "Updated Details:";
    public static final String EVENT_DETAILS_AS_FOLLOWS_MESSAGE = "The event details are as follows:";
    public static final String ASK_FOR_OPTION_MESSAGE = "Which field of the event to edit?"
            + " (Enter Corresponding Number)";
    public static final String OPTION_TO_EDIT_DESCRIPTION = "1. Description";
    public static final String OPTION_TO_EDIT_DATE = "2. Date";
    public static final String OPTION_TO_EDIT_START_TIME = "3. Start Time";
    public static final String OPTION_TO_EDIT_END_TIME = "4. End Time";
    public static final String OPTION_TO_EDIT_PRIORITY = "5. Priority";
    public static final String START_TIME_AFTER_END_TIME = "Event start time after end time exception thrown";
    public static final String PRIORITY_NOT_INTEGER = "Task priority not integer exception thrown";
    public static final String INVALID_END_TIME = "Invalid end time exception thrown";
    public static final String INVALID_START_TIME = "Invalid start time exception thrown";
    public static final String INVALID_DATE = "Invalid date exception thrown";
    public static final String DATE_AFTER_CURRENT_DATE = "Date after current date exception thrown";
    public static final String SEARCH_KEYWORD_EMPTY = "Search keyword empty exception thrown";
    public static final String WRONG_OPTION = "Wrong option entered not handled by getFieldToBeEdited";
    public static final String INVALID_PRIORITY_VALUE = "Invalid priority value entered by user";
    public static final String INVALID_END_TIME_ENTERED = "Invalid end time entered by the user";
    public static final String INVALID_START_TIME_ENTERED = "Invalid start time entered by user";
    public static final String INVALID_DATE_ENTERED = "Invalid date entered by user";
    public static final String INVALID_OPTION_ENTERED = "Invalid option entered by user";

    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setter for priority of the deadline.
     *
     * @param priority The new priority of the event.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Getter function for Start Time of Event.
     *
     * @return Start time of event.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Getter function for End Time of Event.
     *
     * @return End time of event.
     */
    public LocalTime getEndTime() {
        return endTime;
    }


    /**
     * Constructor for Event Class.
     *
     * @param description Description of the event.
     * @param date Date of specified Event.
     * @param startTime Start time of specified event.
     * @param endTime End time of specified event.
     * @param priority Priority of specified event.
     * @throws Exception If wrong format is used for date, time or priority fields.
     */
    public Event(String description, String date, String startTime, String endTime, String priority)
            throws Exception {
        taskType = TaskType.Event;
        parseDescription(description);
        parseDate(date);
        parseStartTime(startTime);
        parseEndTime(endTime);
        if (this.startTime.isAfter(this.endTime)) {
            LOGGER.log(Level.INFO, START_TIME_AFTER_END_TIME);
            throw new EventStartTimeAfterEndTimeException();
        }
        parsePriority(priority);
    }

    /**
     * Parses the priority from the string entered by user for the priority field.
     *
     * @param priority String entered by user for the priority field.
     * @throws Exception If the provided priority isn't an integer.
     */
    private void parsePriority(String priority) throws Exception {
        try {
            this.priority = Integer.parseInt(priority.strip());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, PRIORITY_NOT_INTEGER);
            throw new TaskPriorityNotIntegerException();
        }
    }

    /**
     * Parses the End time from the string entered by user for the endTime field.
     *
     * @param endTime String entered by user for the endTime field.
     * @throws Exception If the provided end time isn't valid.
     */
    private void parseEndTime(String endTime) throws Exception {
        try {
            this.endTime = LocalTime.parse(endTime.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, INVALID_END_TIME);
            throw new InvalidEndTimeException();
        }
    }

    /**
     * Parses the End time from the string entered by user for the startTime field.
     *
     * @param startTime String entered by user for the startTime field.
     * @throws Exception If the provided start time isn't valid.
     */
    private void parseStartTime(String startTime) throws Exception {
        try {
            this.startTime = LocalTime.parse(startTime.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, INVALID_START_TIME);
            throw new InvalidStartTimeException();
        }
    }

    /**
     * Parses the Date from the string entered by user for the date field.
     *
     * @param date String entered by user for the date field.
     * @throws Exception If the provided date isn't valid or is a past date.
     */
    private void parseDate(String date) throws Exception {
        try {
            this.date = LocalDate.parse(date.strip());
        } catch (DateTimeParseException e) {
            LOGGER.log(Level.INFO, INVALID_DATE);
            throw new InvalidDateException();
        }
        if (this.date.isBefore(LocalDate.now())) {
            LOGGER.log(Level.INFO, DATE_AFTER_CURRENT_DATE);
            throw new TaskDateBeforeCurrentDateException();
        }
    }

    /**
     * Parses the description from the string entered by user for the description field.
     *
     * @param description String entered by user for the description field.
     */
    private void parseDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the information related to information in form of a string.
     *
     * @return eventInfo Contains information related to the event.
     */
    public String getTaskInformation() {
        String eventInfo = EVENT_SYMBOL + description + AT + date.format(DateTimeFormatter.ofPattern(DATE_PATTERN))
                + FROM + startTime.toString() + TO + endTime.toString() + WITH_PRIORITY + priority;
        return eventInfo;
    }

    /**
     * Returns the number of days left till the event.
     *
     * @return Number of days till event.
     */
    @Override
    public long numberOfDaysLeft() {
        return ChronoUnit.DAYS.between(LocalDate.now(),this.date);
    }

    /**
     * Returns the priority of the specified event.
     *
     * @return Priority of event.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the date of the event.
     *
     * @return Date of event.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Used to identify if the string contains the keyword specified in its description.
     *
     * @param keyword The keyword to be matched with the description.
     * @return containsKeyword Indicates the presence/absence of keyword in the event's description.
     * @throws Exception If keyword entered is empty.
     */
    public boolean hasKeyword(String keyword) throws Exception {
        if (keyword.equals(EMPTY_STRING)) {
            LOGGER.log(Level.INFO, SEARCH_KEYWORD_EMPTY);
            throw new SearchKeywordEmptyException();
        }
        boolean containsKeyword = description.contains(keyword);
        return containsKeyword;
    }

    /**
     * Returns the event in the format used to store it in the data file.
     *
     * @return formattedEventDetails Contains the event details in the required format.
     */
    public String getFormattedDetails() {
        String formattedEventDetails = EVENT_IDENTIFIER + DELIMITER + description + DELIMITER + date + DELIMITER
                + startTime + DELIMITER + endTime + DELIMITER + priority + NEW_LINE_CHARACTER;
        return formattedEventDetails;
    }

    /**
     * Edits the event at the index specified.
     *
     * @param ui Used to interact with the user.
     * @return Newly updated event.
     */
    public Event editEvent(Ui ui) {
        printOptionsToEdit(ui);
        int fieldToBeEdited = 0;
        fieldToBeEdited = getFieldToBeEdited(ui);
        switch (fieldToBeEdited) {
        case EDIT_DESCRIPTION:
            editDescription(ui);
            break;
        case EDIT_DATE:
            editDate(ui);
            break;
        case EDIT_START_TIME:
            editStartTime(ui);
            break;
        case EDIT_END_TIME:
            editEndTime(ui);
            break;
        case EDIT_PRIORITY:
            editPriority(ui);
            break;
        default:
            LOGGER.log(Level.SEVERE, WRONG_OPTION);
            ui.printMessage(ERROR_MESSAGE);
            break;
        }
        printUpdatedDetails(ui);
        return this;
    }

    /**
     * Used to edit the priority field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editPriority(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(ENTER_NEW_PRIORITY_MESSAGE);
            String newPriorityString = ui.getUserIn();
            try {
                parsePriority(newPriorityString);
            } catch (Exception e) {
                LOGGER.log(Level.INFO, INVALID_PRIORITY_VALUE);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the endTime field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editEndTime(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(ENTER_NEW_END_TIME_MESSAGE);
            String newEndTimeString = ui.getUserIn();
            try {
                parseEndTime(newEndTimeString);
                if (this.endTime.isBefore(this.startTime)) {
                    LOGGER.log(Level.INFO, START_TIME_AFTER_END_TIME);
                    throw new EventStartTimeAfterEndTimeException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, INVALID_END_TIME_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the startTime field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editStartTime(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(ENTER_NEW_START_TIME_MESSAGE);
            String newStartTimeString = ui.getUserIn();
            try {
                parseStartTime(newStartTimeString);
                if (this.endTime.isBefore(this.startTime)) {
                    LOGGER.log(Level.INFO, START_TIME_AFTER_END_TIME);
                    throw new EventStartTimeAfterEndTimeException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, INVALID_START_TIME_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the date field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editDate(Ui ui) {
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            ui.printMessage(ENTER_NEW_DATE_MESSAGE);
            String newDateString = ui.getUserIn();
            try {
                parseDate(newDateString);
                if (this.date.isBefore(LocalDate.now())) {
                    LOGGER.log(Level.INFO, DATE_AFTER_CURRENT_DATE);
                    throw new TaskDateBeforeCurrentDateException();
                }
            } catch (Exception e) {
                LOGGER.log(Level.INFO, INVALID_DATE_ENTERED);
                ui.printMessage(e.getMessage());
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
    }

    /**
     * Used to edit the description field of the event.
     *
     * @param ui Used to interact with the user.
     */
    private void editDescription(Ui ui) {
        ui.printMessage(ENTER_NEW_DESCRIPTION_MESSAGE);
        String newDescription = ui.getUserIn();
        parseDescription(newDescription);
    }

    /**
     * Returns an integer denoting the field selected to be edited later.
     *
     * @param ui Used to interact with the user.
     * @return fieldToBeEdited Corresponds to the field to be edited.
     */
    private int getFieldToBeEdited(Ui ui) {
        int fieldToBeEdited = 0;
        boolean exceptionEncountered;
        do {
            exceptionEncountered = false;
            try {
                fieldToBeEdited = Integer.parseInt(ui.getUserIn());
                boolean isInvalidOption = fieldToBeEdited > 5 || fieldToBeEdited < 0;
                if (isInvalidOption) {
                    throw new Exception();
                }
            } catch (Exception exception) {
                LOGGER.log(Level.INFO, INVALID_OPTION_ENTERED);
                ui.printMessage(ENTER_VALID_NUMBER_FROM_LIST_MESSAGE);
                exceptionEncountered = true;
            }
        } while (exceptionEncountered);
        return fieldToBeEdited;
    }

    /**
     * Prints the updated details of the event after an edit command.
     *
     * @param ui Used to interact with user.
     */
    private void printUpdatedDetails(Ui ui) {
        ui.printMessage(UPDATED_DETAILS);
        ui.printMessage(this.getTaskInformation());
        ui.printLine();
    }

    /**
     * Prints the list of fields that could be edited as a list.
     *
     * @param ui Used to interact with user.
     */
    private void printOptionsToEdit(Ui ui) {
        ui.printLine();
        ui.printMessage(EVENT_DETAILS_AS_FOLLOWS_MESSAGE);
        ui.printMessage(this.getTaskInformation());
        ui.printMessage(ASK_FOR_OPTION_MESSAGE);
        ui.printMessage(OPTION_TO_EDIT_DESCRIPTION);
        ui.printMessage(OPTION_TO_EDIT_DATE);
        ui.printMessage(OPTION_TO_EDIT_START_TIME);
        ui.printMessage(OPTION_TO_EDIT_END_TIME);
        ui.printMessage(OPTION_TO_EDIT_PRIORITY);
        ui.printEmptyLine();
    }
}
