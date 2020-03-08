package event;

import java.time.LocalDate;
import java.time.LocalTime;
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
     * @throws DateTimeParseException If wrong format is used for date, time fields.
     */
    public Event(String description, String date, String startTime, String endTime, String priority)
            throws DateTimeParseException {
        this.description = description;
        this.date = LocalDate.parse(date.strip());
        this.startTime = LocalTime.parse(startTime.strip());
        this.endTime = LocalTime.parse(endTime.strip());
        this.priority = Integer.parseInt(priority.strip());
    }

    /**
     * Returns the information related to information in form of a string.
     *
     * @return eventInfo Contains information related to the event.
     */
    public String getEventInformation() {
        String eventInfo = description + " at " + date.toString() + " from " + startTime.toString()
                + " to " + endTime.toString();
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
     */
    public boolean hasKeyword(String keyword) {
        boolean containsKeyword = description.contains(keyword);
        return containsKeyword;
    }

}
