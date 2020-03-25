package notes.modules.parser;

import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.ExitCommand;
import notes.modules.command.ListCommand;

public class Parser {
    private String userCommandText;
    private String userInput;

    /**
     * Takes in the user input and parse it into understandable
     * commands and return the command needed.
     * @param userInput input from the user
     * @return method to call Command of specific type
     */
    public Command parseCommand(String userInput) {
        this.userInput = userInput;
        userCommandText = userInput.split(" ")[0];

        switch (userCommandText) {
        case "add":
            return addCommand();
        case "list":
            return listCommand();
        case "exit":
            return exitCommand();
        default:
            return null;
        }
    }

    public AddCommand addCommand() {
        String message = userInput.split("add ")[1];
        return new AddCommand(message);
    }

    public ListCommand listCommand() {
        return new ListCommand();
    }

    public ExitCommand exitCommand() {
        return new ExitCommand();
    }
}
