package task;

import ui.Constants;
import ui.Ui;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class TaskScheduler {

    private int numberOfTasksToSchedule;
    private PriorityQueue<SchedulableTask> taskQueue;

    public TaskScheduler(int numberOfTasksToSchedule) {
        this.numberOfTasksToSchedule = numberOfTasksToSchedule;
        this.taskQueue = new PriorityQueue<>(numberOfTasksToSchedule, new TaskComparator());
    }

    public void getTasks(Ui ui) {
        ui.printLine();
        ui.printMessage("Enter tasks in the following format:");
        ui.printMessage("<Time to finish task in days> <Number of days left from current day>");
        for (int i = 0; i < numberOfTasksToSchedule; i++) {
            SchedulableTask newSchedulableTask = new SchedulableTask();
            try {
                String taskDetails = ui.getUserIn();
                String[] splitDetails = taskDetails.split(" ");
                newSchedulableTask.numberOfDaysRequiredToFinishTask = Integer.parseInt(splitDetails[0]);
                newSchedulableTask.numberOfDaysLeft = Integer.parseInt(splitDetails[1]);
            } catch (IndexOutOfBoundsException|NumberFormatException e) {
                ui.printMessage("Please follow the format specified. Renter details:");
                i--;
            }
            taskQueue.add(newSchedulableTask);
        }
        ui.printMessage("Details captured successfully.");
    }

    public boolean scheduleTasks(Ui ui) {
        int currentDay = 0;
        int taskNumber = 1;
        StringBuilder scheduleCreated = new StringBuilder();
        while (!taskQueue.isEmpty()) {
            scheduleCreated.append("Task ").append(taskNumber++).append(" is scheduled from ")
                    .append(LocalDate.now().plusDays(currentDay));
            SchedulableTask taskToBeScheduledNext = taskQueue.poll();
            if (currentDay + taskToBeScheduledNext.numberOfDaysRequiredToFinishTask
                    > taskToBeScheduledNext.numberOfDaysLeft ) {
                return false;
            } else {
                currentDay += taskToBeScheduledNext.numberOfDaysRequiredToFinishTask;
            }
            scheduleCreated.append(" to ").append(LocalDate.now().plusDays(currentDay))
                    .append(System.lineSeparator()).append(Constants.TAB);
        }
        ui.printMessage(scheduleCreated.toString());
        return true;
    }
}

