package driver;

import command.EventCommand;
import event.EventList;
import java.io.FileNotFoundException;

import parser.Parser;
import resourceloader.EventLoader;
import resourceloader.StudyAreaLoader;
import studyarea.IllegalStudyAreaException;
import command.StudyAreaCommand;
import studyarea.StudyAreaList;
import ui.Ui;

public class Driver {
    public static EventLoader eventLoader;
    public static StudyAreaLoader studyAreaLoader;

    /**
     * Constructor for Driver Class.
     * This class setups the loading of events and study areas into
     * the program and runs either study area or organiser functionality.
     *
     * @param mode 1 for organiser, 0 for study area.
     * @param ui Object used to interact with user.
     * @param parser Object used to parse user commands.
     * @throws FileNotFoundException if file is not found.
     * @throws IllegalStudyAreaException custom exception for study area.
     */
    public Driver(int mode, Ui ui, Parser parser) throws FileNotFoundException, IllegalStudyAreaException {
        eventLoader = new EventLoader(Ui.FILE_PATH_EVENTS);
        EventList eventList = new EventList(eventLoader.loadFile());

        studyAreaLoader = new StudyAreaLoader(Ui.FILE_PATH_STUDYAREAS);
        StudyAreaList studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());

        if (mode == 1) {
            EventCommand eventCommand = new EventCommand();
            eventCommand.runCommands(eventList, ui, parser);
            eventLoader.saveEvents(eventList.events);
        } else {
            StudyAreaCommand studyAreaCommand = new StudyAreaCommand();
            studyAreaCommand.runCommands(studyAreaList, ui);
        }
    }
}
