package notes;

import ui.Constants;

import java.io.IOException;
import java.util.Scanner;


//@@author terrytay
public class NotesInvoker {

    /**
     * Constructor to invoke Notes app.
     *
     * @throws IOException exception for module import/export
     */
    public NotesInvoker() throws Exception {
        Notes notes = new Notes();
        System.out.println(Constants.NOTES_WELCOME_MESSAGE);
        System.out.println(Constants.LINE_BREAK);
        displayMenu();

        Scanner input = new Scanner(System.in);
        boolean isExit = false;
        String choice;

        do {
            try {
                String userInput = input.nextLine();
                choice = userInput.split(" ")[0];
                String code;
                switch (choice) {
                case Constants.NOTES_ADD:
                    code = userInput.split(" ",2)[1].trim();
                    notes.createModule(code);
                    break;
                case Constants.NOTES_REMOVE:
                    code = userInput.split(" ",2)[1].trim();
                    notes.deleteModule(code);
                    break;
                case Constants.NOTES_ENTER:
                    code = userInput.split(" ",2)[1].trim();
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
                    displayMenu();
                    break;
                default:
                    System.out.println(Constants.INVALID_NOTES_COMMAND_MESSAGE);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(Constants.NOTES_EXCEPTION_MSG);
            }
        } while (!isExit);

        System.out.println(Constants.NOTES_BYE_MSG);
    }

    private void displayMenu() {
        System.out.println(Constants.ADD_MODULE_MESSAGE);
        System.out.println(Constants.REMOVE_MODULE_MESSAGE);
        System.out.println(Constants.ENTER_MODULE_MESSAGE);
        System.out.println(Constants.LIST_MODULE_MESSAGE);
        System.out.println(Constants.EXIT_MODULE_MESSAGE);
        System.out.println(Constants.HELP_MODULE_MESSAGE);
    }
}
