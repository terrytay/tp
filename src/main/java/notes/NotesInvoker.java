package notes;

import exception.NotesCommandException;
import ui.Constants;
import ui.Ui;

import java.io.IOException;
import java.util.Scanner;

import static ui.Constants.SPACE;
import static ui.Constants.TAB;


//@@author terrytay
public class NotesInvoker {

    /**
     * Constructor to invoke Notes app.
     * @param ui allows for interaction with the user
     * @throws IOException exception for module import/export
     */
    public NotesInvoker(Ui ui) throws Exception {
        Notes notes = new Notes(ui);
        ui.printLine();
        ui.printMessage(Constants.NOTES_WELCOME_MESSAGE);
        ui.printLine();
        displayMenu(ui);
        ui.printLine();
        boolean isExit = false;
        String choice;

        do {
            try {
                String userInput = ui.getUserIn();
                ui.printLine();
                choice = userInput.split(SPACE)[0];
                String code;
                switch (choice) {
                case Constants.NOTES_ADD:
                    code = userInput.split(SPACE)[1];
                    notes.createModule(code);
                    break;
                case Constants.NOTES_REMOVE:
                    code = userInput.split(SPACE)[1];
                    notes.deleteModule(code);
                    break;
                case Constants.NOTES_ENTER:
                    code = userInput.split(SPACE)[1];
                    notes.enterModule(code);
                    break;
                case Constants.NOTES_LIST:
                    notes.listModules();
                    break;
                case Constants.NOTES_BYE:
                    notes.exportModules();
                    isExit = true;
                    break;
                case Constants.NOTES_HELP:
                    displayMenu(ui);
                    break;
                default:
                    ui.printMessage(Constants.INVALID_NOTES_COMMAND_MESSAGE);
                    break;
                }
                if (!isExit) {
                    ui.printLine();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                ui.printLine();
                ui.printMessage(Constants.NOTES_EXCEPTION_MSG);
                ui.printLine();
            }
        } while (!isExit);
        ui.printMessage(Constants.NOTES_BYE_MSG);
        ui.printLine();
    }

    private void displayMenu(Ui ui) {
        ui.printOut(TAB + SPACE + Constants.ADD_MODULE_MESSAGE, true);
        ui.printOut(TAB + SPACE + Constants.REMOVE_MODULE_MESSAGE, true);
        ui.printOut(TAB + SPACE + Constants.ENTER_MODULE_MESSAGE, true);
        ui.printOut(TAB + SPACE + Constants.LIST_MODULE_MESSAGE, true);
        ui.printOut(TAB + SPACE + Constants.EXIT_MODULE_MESSAGE, true);
        ui.printOut(TAB + SPACE + Constants.HELP_MODULE_MESSAGE, true);
    }
}
