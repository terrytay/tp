package command;

import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;
import studyarea.StudyAreaList;
import ui.Ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Study Area Command class. It executes the Study Area Search function and interact with Users accordingly.
 */

public class StudyAreaCommand {

    /**
     * List out all the study areas that match with User's preference.
     * @param availStudyAreas this is the list of all study areas in location.txt.
     */
    public static void printList(ArrayList<StudyArea> availStudyAreas) {
        if (availStudyAreas.isEmpty()) {
            System.out.println(Ui.formatMessage(Ui.EMPTY_LIST, Ui.MAX_LINE_LENGTH));
        } else {
            System.out.println(Ui.formatMessage(Ui.AVAILABLE_STUDY_AREAS, Ui.MAX_LINE_LENGTH));
            for (StudyArea studyArea : availStudyAreas) {
                System.out.println(studyArea.toString());
            }
        }
    }


    /**
     * Filters command based on User Input.
     * @param command This is the command entered by User.
     * @param studyAreaList This is the list of all Study Areas in location.txt.
     * @return boolean status. False if User enters "end" , else will always return true;
     */

    public static boolean filterCommand(String command, StudyAreaList studyAreaList) {
        switch (command) {
        case Ui.BYE_COMMAND :
            System.out.println(Ui.formatMessage(Ui.END_MESSAGE, Ui.MAX_LINE_LENGTH));
            return false;
        case Ui.HELP_COMMAND :
            System.out.println(Ui.FLAGS);
            break;
        default:
            try {
                ArrayList<StudyArea> availStudyAreas = studyAreaList.searchList(command);
                printList(availStudyAreas);
                System.out.println(Ui.formatMessage(Ui.PROMPT_USER, Ui.MAX_LINE_LENGTH));
            } catch (IllegalStudyAreaException e) {
                System.out.println(Ui.formatMessage(e.getMessage(), Ui.MAX_LINE_LENGTH));
            }
        }
        return true;
    }

    /**
     * Executes the Study Area search feature.
     * @param studyAreaList studyAreaList object that holds information on studyAreas available.
     */
    public static void runCommands(StudyAreaList studyAreaList, Ui ui) {
        ui.printLine();
        ui.printMessage(Ui.START_STUDY_AREA_SEARCH);
        boolean status = true;
        while (status) {
            ui.printLine();
            String command = ui.getUserIn();
            ui.printLine();
            status = filterCommand(command, studyAreaList);
        }
        ui.printLine();
    }
}
