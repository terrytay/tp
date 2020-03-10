package event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event and contains the related functions.
 */
public class Event {

    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;

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
        parseDescription(description);
        parseDate(date);
        parseStartTime(startTime);
        parseEndTime(endTime);
        parsePriority(priority);
        if (this.startTime.isAfter(this.endTime)) {
            throw new Exception("Start time should be before End time");
        }
        if (this.date.isBefore(LocalDate.now())) {
            throw new Exception("Date specified must be a current or a future date");
        }
    }

    private void parsePriority(String priority) throws Exception {
        try {
            this.priority = Integer.parseInt(priority.strip());
        } catch (NumberFormatException e) {
            throw new Exception("Priority should be an integer");
        }
    }

    private void parseEndTime(String endTime) throws Exception {
        try {
            this.endTime = LocalTime.parse(endTime.strip());
        } catch (DateTimeParseException e) {
            throw new Exception("End time provided is invalid or in wrong format (Should be HH:MM)");
        }
    }

    private void parseStartTime(String startTime) throws Exception {
        try {
            this.startTime = LocalTime.parse(startTime.strip());
        } catch (DateTimeParseException e) {
            throw new Exception("Start time provided is invalid or in wrong format (Should be HH:MM)");
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
     * @return eventInfo Contains information related to the event.
     */
    public String getEventInformation() {
        String eventInfo = description + " at " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " from "
                + startTime.toString() + " to " + endTime.toString();
        return eventInfo;
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
     * @throws Exception If keyword entered is emoty.
     */
    public boolean hasKeyword(String keyword) throws Exception {
        if (keyword.equals("")) {
            throw new Exception("Keyword is empty");
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
        String formattedEventDetails = description + "#" + date + "#" + startTime + "#" + endTime + "#" + priority;
        return formattedEventDetails;
    }
}
