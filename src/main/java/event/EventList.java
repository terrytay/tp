package event;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ui.Ui;

/**
 * Handles all functions related to the list of events.
 */
public class EventList {

    Ui ui = new Ui();

    /** Stores the event information. */
    public ArrayList<Event> events;

    /**
     * Constructor for the EventList class.
     */
    public EventList() {
        events = new ArrayList<Event>();
    }

    public EventList(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Adds a new event to the list.
     *
     * @param newEvent Event represents the new event tot be added.
     */
    public void addEvent(Event newEvent) {
        ui.printLine();
        events.add(newEvent);
        ui.printWithIndentation("A new event with the following information has been added.");
        ui.printWithIndentation(newEvent.getEventInformation());
        ui.printLine();
        events.add(newEvent);
    }

    /**
     * Displays the current list of events.
     */
    public void listEvents() {
        ui.printLine();
        System.out.println("Here is the list of events added so far:");
        int eventNumber = 1;
        for (Event event: events) {
            ui.printWithIndentation(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        ui.printLine();
    }

    /**
     * Deletes the event at the specified index.
     *
     * @param index The index (1-based) of the event to be deleted.
     */
    public void deleteEvent(int index) {
        try {
            events.remove(index - 1);
            ui.printLine();
            ui.printWithIndentation("The event at the mentioned index has been deleted");
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            ui.printLine();
            ui.printWithIndentation("Enter a valid index");
            ui.printLine();
        }

    }

    /**
     * Clears all the events currently stored.
     */
    public void clearEvents() {
        events.clear();
        ui.printLine();
        ui.printWithIndentation("The list of events is cleared.");
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by their priority.
     */
    public void priorityView() {
        ArrayList<Event> eventsSortedByPriority = events;
        eventsSortedByPriority.sort(Comparator.comparingInt(Event::getPriority));
        Collections.reverse(eventsSortedByPriority);
        ui.printLine();
        int eventNumber = 1;
        for (Event event:eventsSortedByPriority) {
            ui.printWithIndentation(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printWithIndentation("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by date along with the days remaining.
     */
    public void countdownView() {
        ArrayList<Event> eventsSortedByDate = events;
        eventsSortedByDate.sort(Comparator.comparing(Event::getDate));
        ui.printLine();
        int eventNumber = 1;
        for (Event event:eventsSortedByDate) {
            ui.printWithIndentation(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printWithIndentation("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Displays the list of events containing the keyword.
     *
     * @param keyword The keyword to be searched for.
     */
    public void searchEvents(String keyword) {
        ui.printLine();
        int eventNumber = 1;
        for (Event event:events) {
            if (event.hasKeyword(keyword)) {
                ui.printWithIndentation(eventNumber + ") " + event.getEventInformation());
                eventNumber++;
            }
        }
        if (eventNumber == 1) {
            ui.printWithIndentation("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Adds a new event to the list by parsing information from the user given string
     * and calling {@link #addEvent(Event)} if the information is given in the correct format
     * to add the event.
     *
     * @param eventDetails Contains all the information related to the event as provided by the user.
     */
    public void add(String eventDetails) {
        try {
            String[] details = eventDetails.split(" ",2)[1].split("/");
            String description = details[0];
            String date = details[1].substring(2);
            String startTime = details[2].substring(2);
            String endTime = details[3].substring(2);
            String priority = details[4].substring(2);
            Event newEvent =  new Event(description,date,startTime,endTime,priority);
            addEvent(newEvent);
        } catch (IndexOutOfBoundsException | DateTimeParseException | NullPointerException e) {
            ui.printLine();
            ui.printWithIndentation("Wrong format to add events");
            ui.printLine();
        }
    }
}
