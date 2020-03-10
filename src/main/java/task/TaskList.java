package task;

abstract public class TaskList {
    /**
     * TaskList is an abstract class that oversees all task-related classes.
     * The current task-related classes are events, deadlines, assignments
     * TaskList stores all tasks in one large array, allowing the user to access the priorityView and countdownView of all tasks
     */


    abstract public void priorityView();
    abstract public void countdownView();
    abstract public void searchTasks();
}
