package task;

//@@author GanapathySanathBalaji

public class SchedulableTask {

    public String taskName;
    public int numberOfDaysLeft;
    public int numberOfDaysRequiredToFinishTask;


    /**
     * Sets the details of Schedulable Task object with the information provided in the splitDetails.
     *
     * @param splitDetails Contains all the details of the schedulable task.
     * @throws Exception If the details entered are invalid.
     */
    public void setDetails(String[] splitDetails) throws Exception {
        if (splitDetails.length != 3) {
            throw new Exception("Please follow the format specified");
        }
        this.taskName = splitDetails[0];
        if (taskName.isBlank()) {
            throw new Exception("Name of task shouldn't be empty");
        }
        try {
            this.numberOfDaysRequiredToFinishTask = Integer.parseInt(splitDetails[1].substring(2)
                    .trim());
        } catch (NumberFormatException e) {
            throw new Exception("Number of days to finish task should be an integer");
        }
        try {
            this.numberOfDaysLeft = Integer.parseInt(splitDetails[2].substring(2).trim());
        } catch (NumberFormatException e) {
            throw new Exception("Number of days left should be an integer");
        }
        if (this.numberOfDaysRequiredToFinishTask < 1) {
            throw new Exception("Number of days to finish should be greater than 1");
        }
        if (this.numberOfDaysLeft < 1) {
            throw new Exception("Number of days left should be greater than 1");
        }
        if (this.numberOfDaysLeft < this.numberOfDaysRequiredToFinishTask) {
            throw new Exception("Number of days left should not be lesser than number of days to finish the task");
        }

    }

}
