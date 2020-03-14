package task.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import task.Event;
import task.Task;
import task.Deadline;
import ui.Ui;

/**
 * Handles all functions related to the list of events.
 */
public class TaskList {


    /**
     * Stores the task's information.
     */
    public ArrayList<Task> tasks;

    /**
     * Constructor for the TaskList class.
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Overloaded constructor for TaskList class.
     *
     * @param tasks The list of events the task's list of events is initialised with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the number of tasks currently stored.
     *
     * @return The number of tasks stored currently.
     */
    public int getTaskListSize() {
        return tasks.size();
    }

    /**
     * Adds a new task to the list.
     *
     * @param ui      This allows Task List class to interact with User.
     * @param newTask represents the new task to be added.
     */
    public void addTask(Task newTask, Ui ui) {
        tasks.add(newTask);
        ui.printLine();
        ui.printMessage("A new event with the following information has been added.");
        ui.printMessage(newTask.getTaskInformation());
        ui.printLine();
    }

    /**
     * Displays the current list of tasks.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void listTasks(Ui ui) {
        ui.printLine();
        ui.printMessage("Here is the list of events added so far:");
        int eventNumber = 1;
        for (Task task : tasks) {
            ui.printMessage(eventNumber + ") " + task.getTaskInformation());
            eventNumber++;
        }
        ui.printLine();
    }

    /**
     * Deletes the task at the specified index.
     *
     * @param ui    This allows TaskList class to interact with User.
     * @param index The index (1-based) of the task to be deleted.
     */
    public void deleteTask(int index, Ui ui) {
        ui.printLine();
        try {
            if (index > tasks.size() | index <= 0) {
                throw new IndexOutOfBoundsException();
            }
            tasks.remove(index - 1);
            ui.printLine();
            ui.printMessage("The task at the mentioned index has been deleted");
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            ui.printMessage("Invalid index entered. Please enter a valid index to be deleted");
            ui.printLine();
        }
    }

    /**
     * Calls a helper function to edit the task at the specified index.
     *
     * @param ui    This allows TaskList class to interact with User.
     * @param index The index (1-based) of the task to be deleted.
     */
    public void editTask(int index, Ui ui) {
        ui.printLine();
        try {
            if (index > tasks.size() | index <= 0) {
                throw new IndexOutOfBoundsException();
            }
            /* Converting to '0' based index */
            editTaskAtIndex(index - 1, ui);
            ui.printLine();
            ui.printMessage("The task at the mentioned index has been edited successfully");
            ui.printLine();
        } catch (IndexOutOfBoundsException e) {
            ui.printMessage("Invalid index entered. Please enter a valid index to be edited");
            ui.printLine();
        }
    }


    /**
     * Edits the task at the specified index.
     *
     * @param index The index of the task to be edited.
     * @param ui This allows TaskList class to interact with User.
     * @throws IndexOutOfBoundsException If the index provided is invalid (i.e, out of bounds).
     */
    private void editTaskAtIndex(int index, Ui ui) throws IndexOutOfBoundsException {
        switch (tasks.get(index).taskType) {
        case Event:
            Event oldEvent = (Event) tasks.get(index);
            Event updatedEvent = oldEvent.editEvent(ui);
            tasks.set(index, updatedEvent);
            break;
        case Deadline:
            Deadline oldDeadline = (Deadline) tasks.get(index);
            Deadline updatedDeadline = oldDeadline.editDeadline(ui);
            tasks.set(index, updatedDeadline);
            break;
        default:
            ui.printMessage("Error encountered during execution");
            break;
        }
    }


    /**
     * Clears all the tasks currently stored.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void clearTasks(Ui ui) {
        tasks.clear();
        ui.printLine();
        ui.printMessage("The list of tasks is cleared.");
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by their priority.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void priorityView(Ui ui) {
        ArrayList<Task> tasksSortedByPriority = tasks;
        tasksSortedByPriority.sort(Comparator.comparingInt(Task::getPriority));
        Collections.reverse(tasksSortedByPriority);
        ui.printLine();
        int taskNumber = 1;
        for (Task task : tasksSortedByPriority) {
            ui.printMessage(taskNumber + ") " + task.getTaskInformation());
            taskNumber++;
        }
        if (taskNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Lists all the tasks sorted by date along with the days remaining.
     *
     * @param ui This allows TaskList class to interact with User.
     */
    public void countdownView(Ui ui) {
        ArrayList<Task> tasksSortedByDate = tasks;
        tasksSortedByDate.sort(Comparator.comparing(Task::getDate));
        ui.printLine();
        int taskNumber = 1;
        for (Task task : tasksSortedByDate) {
            ui.printMessage(taskNumber + ") " + task.getTaskInformation());
            taskNumber++;
        }
        if (taskNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

    /**
     * Displays the list of tasks containing the keyword.
     *
     * @param ui      This allows TaskList class to interact with User.
     * @param keyword The keyword to be searched for.
     * @throws Exception If the keyword is empty.
     */
    public void searchTasks(String keyword, Ui ui) throws Exception {
        int taskNumber = 1;
        ui.printLine();
        for (Task task : tasks) {
            if (task.hasKeyword(keyword)) {
                ui.printMessage(taskNumber + ") " + task.getTaskInformation());
                taskNumber++;
            }
        }
        if (taskNumber == 1) {
            ui.printMessage("The list is empty.");
        }
        ui.printLine();
    }

}
