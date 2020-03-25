package command;

import parser.Parser;
import studyarea.StudyAreaList;
import task.TaskList;
import ui.Ui;

import static ui.Constants.BYE_COMMAND;
import static ui.Constants.STUDY_AREA_COMMAND;

/**
 * Used to run all the functions related to tasks.
 */
public class TaskCommand {

    /**
     * Runs all the command for tasks.
     *
     * @param taskList Refers to the current list of tasks.
     * @param ui UI object used to interact with user.
     * @param parser Object used to parse the user input into commands.
     * @param studyAreaList Object is used to access all existing study area.
     */
    public static void runCommands(TaskList taskList, Ui ui, Parser parser, StudyAreaList studyAreaList) {
        String fullCommand;
        Command command;

        fullCommand = ui.getUserIn().trim().toLowerCase();
        while (!fullCommand.equals(BYE_COMMAND)) {
            try {
                if(fullCommand.equals(STUDY_AREA_COMMAND)){
                    new StudyAreaCommand().executeCommand(studyAreaList, ui);
                } else {
                    command = parser.parseCommand(fullCommand);
                    command.executeCommand(taskList, ui);
                }
            } catch (Exception exception) {
                ui.printLine();
                ui.printMessage(exception.getMessage());
                ui.printLine();
            }
            fullCommand = ui.getUserIn();

        }
    }
}
