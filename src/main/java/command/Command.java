package command;

import studyarea.StudyAreaList;
import task.TaskList;
import ui.Ui;


/**
 * Object represents a command and contains all the required information and implementation to execute it.
 */
public abstract class Command {
    public boolean isStudy = false;


    /**
     * This method allows for study area command to be executed as it requires a different param.
     * @param studyAreaList this is the list of all available study areas
     * @param ui this allows for interaction with the user.
     */
    public abstract void executeCommand(StudyAreaList studyAreaList, Ui ui);

    /**
     * Executes the command based on the information provided by the user.
     *
     * @param taskList Contains the list of tasks on which the commands are executed on.
     * @param ui This handles the interaction with Users.
     * @throws Exception If issues are found during execution of command.
     */
    public abstract void executeCommand(TaskList taskList, Ui ui) throws Exception;

}
