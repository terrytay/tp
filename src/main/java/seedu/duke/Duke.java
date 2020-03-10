package seedu.duke;

import driver.Driver;
import event.EventList;
import parser.Parser;
import command.EventCommand;
import command.StudyAreaCommand;
import resourceloader.EventLoader;
import resourceloader.StudyAreaLoader;
import studyarea.IllegalStudyAreaException;
import studyarea.StudyAreaList;
import ui.Ui;
import java.io.FileNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * This is Duke class, which forms the main class of the program.
 */
public class Duke {
    private static EventLoader eventLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static EventList eventList = new EventList();
    private static StudyAreaList studyAreaList;
    private static Ui ui;
    private static Parser parser;

    /**
     * This is the constructor to create a new Duke program every time user runs the main loop.
     */
    public Duke()  {
        try {
            ui = new Ui();
            parser = new Parser();
            eventLoader = new EventLoader(Ui.FILE_PATH_EVENTS);
            eventList = new EventList(eventLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(Ui.FILE_PATH_STUDYAREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e) {
            Ui ui = new Ui();
            ui.printMessage(e.getMessage());
        }
    }

    /**
     * This method runs the program.
     */
    public void run() {
        ui.printWelcomeMessage();
        boolean status = true;
        while (status) {
            int mode = ui.getMode();
            switch (mode) {
            case -1:
                status = false;
                break;
            case 1:
                EventCommand.runCommands(eventList, ui, parser);
                break;
            case 2:
                StudyAreaCommand.runCommands(studyAreaList, ui);
                break;
            default:
                ui.printLine();
                ui.printMessage(Ui.WRONG_INPUT);
                break;
            }
            ui.printWithIndentation(Ui.INTERMEDIATE_MESSAGE);
            ui.printLine();
        }
        eventLoader.saveEvents(eventList.events);
        ui.printMessage(Ui.GOODBYE_MESSAGE + Ui.DAB);
        ui.close();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args this is an optional argument.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

}
