package notes.modules.parser;

import exception.NotesInvalidAddMessageException;
import notes.modules.ModuleManager;
import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.ExitCommand;
import notes.modules.command.ListCommand;
import ui.Constants;
import ui.Ui;

//@@author terrytay
public class Parser {
    private String userCommandText;
    private String userInput;

    /**
     * Takes in the user input and parse it into understandable
     * commands and return the command needed.
     *
     * @param moduleManager ModuleManager object used to manage modules.
     * @param userInput input from the user
     * @param ui allows for interaction with the user
     * @return method to call Command of specific type
     * @throws Exception for invalid commands
     */
    public Command parseCommand(String userInput, ModuleManager moduleManager, Ui ui) throws Exception {
        try {
            this.userInput = userInput;
            userCommandText = userInput.split(Constants.SPACE)[0];

            switch (userCommandText) {
            case Constants.NOTES_PARSER_REDO:
            case Constants.NOTES_PARSER_UNDO:
                return new AddCommand(
                        moduleManager, userCommandText);
            case Constants.NOTES_PARSER_ADD:
                String message = userInput.split(userCommandText + Constants.SPACE)[1];
                return new AddCommand(
                        moduleManager, message, userCommandText);
            case Constants.NOTES_PARSER_LIST:
                return new ListCommand(moduleManager.getMessages(), ui);
            case Constants.NOTES_PARSER_BACK:
                return new ExitCommand();
            default:
                throw new Exception();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.printLine();
            ui.printMessage(Constants.NOTES_PARSER_INVALID_INPUT);
            ui.printLine();
        } catch (Exception e) {
            ui.printLine();
            ui.printMessage(Constants.NOTES_PARSER_INVALID_INPUT_2);
            ui.printLine();
        }
        return null;
    }
}
