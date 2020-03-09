package studyarea;

import ui.Ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static studyarea.Utility.AVAILABLE_STUDY_AREAS;
import static studyarea.Utility.EMPTY_COMMAND;
import static studyarea.Utility.EMPTY_LIST;
import static studyarea.Utility.END_COMMAND;
import static studyarea.Utility.END_MESSAGE;
import static studyarea.Utility.FLAGS;
import static studyarea.Utility.HELP_COMMAND;
import static studyarea.Utility.MAX_LINE_LENGTH;
import static studyarea.Utility.PROMPT_USER;
import static studyarea.Utility.START_STUDY_AREA_SEARCH;
import static studyarea.Utility.formatMessage;

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
            System.out.println(formatMessage(EMPTY_LIST, MAX_LINE_LENGTH));
        } else {
            System.out.println(formatMessage(AVAILABLE_STUDY_AREAS, MAX_LINE_LENGTH));
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
     * @throws IllegalStudyAreaException if command is invalid.
     */

    public static boolean filterCommand(String command,StudyAreaList studyAreaList) throws IllegalStudyAreaException {

        command = command.trim();
        if (command.isEmpty()) {
            throw new IllegalStudyAreaException(EMPTY_COMMAND);
        } else {
            switch (command) {
            case END_COMMAND:
                System.out.println(formatMessage(END_MESSAGE, MAX_LINE_LENGTH));
                return false;
            case HELP_COMMAND:
                System.out.println(FLAGS);
                break;
            default:
                try {
                    ArrayList<StudyArea> availStudyAreas = studyAreaList.searchList(command);
                    printList(availStudyAreas);
                    System.out.println(formatMessage(PROMPT_USER, MAX_LINE_LENGTH));
                } catch (IllegalStudyAreaException e) {
                    System.out.println(formatMessage(e.getMessage(), MAX_LINE_LENGTH));
                }
            }
            return true;
        }
    }

    /**
     * Executes the Study Area search feature.
     * @param args this is temporary.
     * @throws FileNotFoundException If location.txt does not ext, this exception is thrown.
     * @throws IllegalStudyAreaException If data is inconsistent while loading available list, this exception is thrown.
     */

    public static void main(String[] args) throws FileNotFoundException, IllegalStudyAreaException {

        Ui ui = new Ui();
        ui.printLine();
        System.out.println(formatMessage(START_STUDY_AREA_SEARCH, MAX_LINE_LENGTH));
        Scanner in = new Scanner(System.in);
        StudyAreaList studyAreaList = new StudyAreaList();
        boolean status = true;
        while (status) {
            ui.printLine();
            String command = in.nextLine();
            ui.printLine();
            status = filterCommand(command, studyAreaList);
        }
        ui.printLine();
        in.close();
    }
}
