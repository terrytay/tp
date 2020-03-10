package deadline;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an deadline and contains the related functions.
 */
public class Deadline {

    private String description;
    private LocalDate date;
    private LocalTime dueTime;
    private int priority;

    /**
     * Constructor for Deadline
     *Class.
     *
     * @param description Description of the deadline.
     * @param date Date of specified Deadline
     * @param dueTime Due time of specified deadline.
     * @param priority Priority of specified deadline.
     * @throws Exception If wrong format is used for date, time fields.
     */
    public Deadline(String description, String date, String dueTime, String priority) throws Exception {
        parseDescription(description);
        parseDate(date);
        parseDueTime(dueTime);
        parsePriority(priority);
    }

    private void parsePriority(String priority) throws Exception {
        try {
            this.priority = Integer.parseInt(priority.strip());
        } catch (NumberFormatException e) {
            throw new Exception("Priority should be an integer");
        }
    }

    private void parseDueTime(String dueTime) throws Exception {
        try {
            this.dueTime = LocalTime.parse(dueTime.strip());
        } catch (DateTimeParseException e) {
            throw new Exception("Due time provided is invalid or in wrong format (Should be HH:MM)");
        }
    }

    private void parseDate(String date) throws Exception {
        try {
            this.date = LocalDate.parse(date.strip());
        } catch (DateTimeParseException e) {
            throw new Exception("Date provided is invalid or is in wrong format (Should be YYYY-MM-DD)");
        }

    }

    private void parseDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the information related to information in form of a string.
     *
     * @return deadlineInfo Contains information related to the deadline.
     */
    public String getDeadlineInformation() {
        String deadlineInfo = description + " on " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " at "
                + dueTime.toString();
        return deadlineInfo;
    }

    /**
     * Returns the priority of the specified deadline.
     *
     * @return Priority of deadline.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the date of the deadline.
     *
     * @return Date of deadline.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Used to identify if the string contains the keyword specified in its description.
     *
     * @param keyword The keyword to be matched with the description.
     * @return containsKeyword Indicates the presence/absence of keyword in the deadline's description.
     * @throws Exception If no keyword is entered.
     */
    public boolean hasKeyword(String keyword) throws Exception {
        if (keyword.equals("")) {
            throw new Exception("Keyword is empty");
        }
        boolean containsKeyword = description.contains(keyword);
        return containsKeyword;
    }

    /**
     * Returns the deadline in the format used to store it in the data file.
     *
     * @return formattedDeadlineDetails Contains the deadline details in the required format.
     */
    public String getFormattedDetails() {
        String formattedDeadlineDetails = description + "#" + date + "#" + dueTime + "#" + priority;
        return formattedDeadlineDetails;
    }
}