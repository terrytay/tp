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
     * @param ui This allows Event List class to interact with User.
     * @param newEvent Event represents the new event tot be added.
     */
    public void addEvent(Event newEvent, Ui ui) {
        events.add(newEvent);
        ui.printMessage("A new event with the following information has been added.");
        ui.printMessage(newEvent.getEventInformation());
    }

    /**
     * Displays the current list of events.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void listEvents(Ui ui) {
        ui.printMessage("Here is the list of events added so far:");
        int eventNumber = 1;
        for (Event event: events) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
    }

    /**
     * Deletes the event at the specified index.
     *
     * @param ui This allows Event List class to interact with User.
     * @param index The index (1-based) of the event to be deleted.
     */
    public void deleteEvent(int index, Ui ui) {
        try {
            events.remove(index - 1);
            ui.printMessage("The event at the mentioned index has been deleted");
        } catch (IndexOutOfBoundsException e) {
            ui.printMessage("Enter a valid index");
        }

    }

    /**
     * Clears all the events currently stored.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void clearEvents(Ui ui) {
        events.clear();
        ui.printMessage("The list of events is cleared.");
    }

    /**
     * Lists all the tasks sorted by their priority.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void priorityView(Ui ui) {
        ArrayList<Event> eventsSortedByPriority = events;
        eventsSortedByPriority.sort(Comparator.comparingInt(Event::getPriority));
        Collections.reverse(eventsSortedByPriority);
        int eventNumber = 1;
        for (Event event:eventsSortedByPriority) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
    }

    /**
     * Lists all the tasks sorted by date along with the days remaining.
     *
     * @param ui This allows Event List class to interact with User.
     */
    public void countdownView(Ui ui) {
        ArrayList<Event> eventsSortedByDate = events;
        eventsSortedByDate.sort(Comparator.comparing(Event::getDate));
        int eventNumber = 1;
        for (Event event:eventsSortedByDate) {
            ui.printMessage(eventNumber + ") " + event.getEventInformation());
            eventNumber++;
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
    }

    /**
     * Displays the list of events containing the keyword.
     *
     * @param ui This allows Event List class to interact with User.
     * @param keyword The keyword to be searched for.
     */
    public void searchEvents(String keyword, Ui ui) {
        int eventNumber = 1;
        for (Event event:events) {
            try {
                if (event.hasKeyword(keyword)) {
                    ui.printMessage(eventNumber + ") " + event.getEventInformation());
                    eventNumber++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (eventNumber == 1) {
            ui.printMessage("The list is empty.");
        }
    }

    /**
     * Adds a new event to the list by parsing information from the user given string
     * and calling {@link #addEvent(Event, Ui)} if the information is given in the correct format
     * to add the event.
     *
     * @param ui This allows Event List class to interact with User.
     * @param eventDetails Contains all the information related to the event as provided by the user.
     */
    public void add(String eventDetails, Ui ui) {
        try {
            String[] details = eventDetails.split(" ",2)[1].split("/");
            String description = details[0];
            String date = details[1].substring(2);
            String startTime = details[2].substring(2);
            String endTime = details[3].substring(2);
            String priority = details[4].substring(2);
            Event newEvent =  new Event(description,date,startTime,endTime,priority);
            addEvent(newEvent, ui);
        } catch (IndexOutOfBoundsException | DateTimeParseException | NullPointerException e) {
            ui.printMessage("Wrong format to add events");
        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }
    }
}