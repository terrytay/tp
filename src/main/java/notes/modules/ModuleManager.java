package notes.modules;

import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.CommandStack;
import notes.modules.command.ExitCommand;
import notes.modules.parser.Parser;
import ui.Constants;

import java.util.ArrayList;
import java.util.Scanner;

//@@author terrytay
public class ModuleManager {
    private String code;
    private ArrayList<String> messages;
    private CommandStack commandStack;

    /**
     * Manages the module e.g. overall commands and control.
     * @param code module code
     * @param messages the notes in the module
     * @throws Exception for commandStack
     */
    public ModuleManager(String code, ArrayList<String> messages) throws Exception {
        this.code = code;
        this.messages = messages;
        commandStack = new CommandStack();
        runInstance();
    }

    private void runInstance() throws Exception {
        System.out.println(String.format("Notes for %s", code));
        Command command;
        showMenu();
        boolean isExit = false;
        do {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            command = new Parser().parseCommand(userInput, this);
            if (command != null) {
                executeCommand(command);
            }
            if (ExitCommand.isExit(command)) {
                isExit = true;
            }
        } while (!isExit);

    }

    /**
     * Takes the command and execute. Depending on whether it's add,
     * redo or undo or others, it will run differently.
     * @param command the command to be executed
     */
    public void executeCommand(Command command) {
        if (command instanceof AddCommand) {
            switch (((AddCommand) command).getUserCommandType()) {
            case Constants.NOTES_PARSER_ADD:
                commandStack.execute(command);
                break;
            case Constants.NOTES_PARSER_UNDO:
                commandStack.undo();
                break;
            case Constants.NOTES_PARSER_REDO:
                commandStack.redo();
                break;
            default:
                break;
            }
        } else {
            command.execute();
        }

    }

    private void showMenu() {
        System.out.println(Constants.MODULE_MANAGER_1);
        System.out.println(Constants.MODULE_MANAGER_2);
        System.out.println(Constants.MODULE_MANAGER_3);
        System.out.println(Constants.MODULE_MANAGER_4);
        System.out.println(Constants.MODULE_MANAGER_5);
    }

    public void addMessage(String message) {
        messages.add(message);
        System.out.println(Constants.ACTION_SUCCESS);
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void removeMessage(String message) {
        messages.remove(message);
        System.out.println(Constants.ACTION_SUCCESS);
    }
}
