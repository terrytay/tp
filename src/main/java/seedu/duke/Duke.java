package seedu.duke;


import command.Command;
import command.studyarea.StudyAreaCommand;
import exception.IllegalStudyAreaException;
import notes.NotesInvoker;
import parser.Parser;
import resourceloader.StudyAreaLoader;
import resourceloader.TaskLoader;
import studyarea.StudyAreaList;
import task.TaskList;
import ui.Constants;
import ui.Ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static ui.Constants.BYE_COMMAND;
import static ui.Constants.NOTES_COMMAND;
import static ui.Constants.STUDY_AREA_COMMAND;

/**
 * This is Duke class, which forms the main class of the program.
 */
public class Duke {

    private static TaskLoader taskLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static TaskList taskList = new TaskList();
    private static StudyAreaList studyAreaList;
    private static Ui ui;
    private static Parser parser;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * This is the constructor to create a new Duke program every time user runs the main loop.
     */
    public Duke()  {
        try {
            setupLogger();
            parser = new Parser();
            ui = new Ui();
            taskLoader = new TaskLoader(Constants.FILE_PATH_EVENTS);
            taskList = new TaskList(taskLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(Constants.FILE_PATH_STUDY_AREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_ENCOUNTERED_MESSAGE, e);
            ui.printLine();
            ui.printMessage(e.getMessage());
            ui.printLine();
        }
    }

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
                if (fullCommand.equals(STUDY_AREA_COMMAND)) {
                    new StudyAreaCommand().executeStudyCommand(studyAreaList, ui);
                } else if (fullCommand.equals(NOTES_COMMAND)) {
                    new NotesInvoker();
                } else {
                    command = parser.parseCommand(fullCommand);
                    command.executeCommand(taskList, ui);
                }
            } catch (Exception exception) {
                ui.printLine();
                ui.printMessage(exception.getMessage());
                ui.printLine();
            }
            fullCommand = ui.getUserIn().trim().toLowerCase();
        }
    }

    //@@author GanapathySanathBalaji
    private void setupLogger() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        ch.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(ch);
        try {
            FileHandler fh = new FileHandler(Constants.DUKE_LOGGER_LOG);
            fh.setLevel(Level.INFO);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Constants.FILE_LOGGER_NOT_WORKING_MESSAGE, e);
        }
    }

    //@@author ganapathysanathbalaji and NizarMohd
    /**
     * This method runs the program.
     */

    public void run() {
        ui.printWelcomeMessage();
        LOGGER.log(Level.INFO, Constants.APPLICATION_STARTED_EXECUTION);
        LOGGER.log(Level.INFO, Constants.TASK_MODE);
        runCommands(taskList, ui, parser, studyAreaList);
        taskLoader.saveTasks(taskList.tasks);
        LOGGER.log(Level.INFO, Constants.APPLICATION_GOING_TO_EXIT);
        ui.printByeMessage();
        ui.close();
        LOGGER.log(Level.INFO, Constants.APPLICATION_CLOSED_SUCCESSFULLY);
    }

    //@@author NizarMohd
    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args this is an optional argument.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

}
