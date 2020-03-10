package seedu.duke;

public class Duke {
    private static EventLoader eventLoader;
    protected static StudyAreaLoader studyAreaLoader;
    private static EventList eventList;
    private static StudyAreaList studyAreaList;

    private static Ui ui = new Ui();

    /**
     * This method runs the program.
     */
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
            case 1:
                EventCommand.runCommands(eventList, ui, eventLoader);
                eventLoader.saveEvents(eventList.events);
                break;
            case 2:
                StudyAreaCommand.runCommands(studyAreaList, ui);
                break;
            default:
                ui.printLine();
                ui.printMessage(Ui.WRONG_INPUT);
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
    public static void main(String[] args) {
        new Duke().run();
    }
}
