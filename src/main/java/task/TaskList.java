package task;

public abstract class TaskList {
    /**
     * TaskList is an abstract class that oversees all task-related classes.
     * The current task-related classes are events, deadlines, assignments
     * TaskList stores all tasks in one large array, allowing the user to access the priorityView and countdownView of
     * all tasks
     */


    public abstract void priorityView();

    public abstract void countdownView();

    public abstract void searchTasks();
}