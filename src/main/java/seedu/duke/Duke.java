package seedu.duke;

import command.EventCommand;
import command.StudyAreaCommand;
import event.EventList;
import resourceloader.EventLoader;
import resourceloader.StudyAreaLoader;
import studyarea.IllegalStudyAreaException;
import studyarea.StudyAreaList;
import ui.Ui;
import java.io.FileNotFoundException;

public class Duke {
    private static EventLoader eventLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static EventList eventList;
    private static StudyAreaList studyAreaList;

    public Duke()  {
        try {
            eventLoader = new EventLoader(Ui.FILE_PATH_EVENTS);
            eventList = new EventList(eventLoader.loadFile());
            studyAreaLoader = new StudyAreaLoader(Ui.FILE_PATH_STUDYAREAS);
            studyAreaList = new StudyAreaList(studyAreaLoader.pushToDatabase());
        } catch (FileNotFoundException | IllegalStudyAreaException e){
            Ui ui = new Ui();
            ui.printMessage(e.getMessage());
            ui.close();
        }
    }

    public void run() {
        Ui ui = new Ui();
        ui.printWelcomeMessage();
        boolean status = true;
        while (status) {
            int mode = ui.getMode();
            switch (mode) {
            case -1:
                status = false;
                break;
            case 0:
                ui.printMessage(Ui.WRONG_INPUT);
                break;
            case 1:
                EventCommand.runCommands(eventList, ui, eventLoader);
                eventLoader.saveEvents(eventList.events);
                break;
            case 2:
                StudyAreaCommand.runCommands(studyAreaList, ui);
                break;
            }
            ui.printMessage(Ui.INTERMEDIATE_MESSAGE);
            ui.printLine();
        }
        ui.printMessage(Ui.GOODBYE_MESSAGE + Ui.DAB);
        ui.close();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     * @param args this is an optional argument.
     */
    public static void main(String[] args)  {
        new Duke().run();
    }
}
