package seedu.duke;

<<<<<<< HEAD
import driver.Driver;
import ui.Ui;

import java.util.Scanner;


=======
import command.EventCommand;
import command.StudyAreaCommand;
import event.EventList;
import resourceloader.EventLoader;
import resourceloader.StudyAreaLoader;
import studyarea.IllegalStudyAreaException;
import studyarea.StudyAreaList;
import ui.Ui;
import java.io.FileNotFoundException;

/**
 * This is Duke class, which forms the main class of the program.
 */
>>>>>>> cb1907aabe01760a87165c0602e65410ba6ae247
public class Duke {

    /**
     * This is the constructor to create a new Duke program every time user runs the main loop.
     */
    public Duke()  {
        try {
            eventLoader = new EventLoader(Ui.FILE_PATH_EVENTS);
            eventList = new EventList(eventLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(Ui.FILE_PATH_STUDYAREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e) {
            Ui ui = new Ui();
            ui.printMessage(e.getMessage());
            ui.close();
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     * @param args Commandline argument
     */
    public static void main(String[] args) throws Exception {
        ui.printWelcomeMessage();

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        /**
         * To run:
         * events: enter 1
         * study areas: enter 0
         * To end events loop: enter bye in events prog
         * To end study areas loop: enter end in study area loop
         * To end overall prog, enter ctrl+c or ctrl+z
         * Take note: this is still temporary
         */
        while (true) {
            Scanner mode = new Scanner(System.in);
            Driver driver = new Driver(mode.nextInt());
        }
    }
}