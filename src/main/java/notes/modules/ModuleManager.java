package notes.modules;



import notes.modules.command.AddCommand;
import notes.modules.command.Command;
import notes.modules.command.ExitCommand;
import notes.modules.command.ListCommand;
import notes.modules.parser.Parser;

import java.util.ArrayList;
import java.util.Scanner;

public class ModuleManager {
    private String code;
    private ArrayList<String> messages;

    /**
     * Manages the module e.g. overall commands and control.
     * @param code module code
     * @param messages the notes in the module
     */
    public ModuleManager(String code, ArrayList<String> messages) {
        this.code = code;
        this.messages = messages;
        runInstance();
    }

    private void runInstance() {
        System.out.println(String.format("Notes for %s", code));
        Command command;
        do {
            showMenu();
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            command = new Parser().parseCommand(userInput);
            command.execute(messages);
        } while (!ExitCommand.isExit(command));

    }


    private void showMenu() {
        System.out.println("[add] to add a note");
        System.out.println("[undo] to undo");
        System.out.println("[redo] to redo");
        System.out.println("[list] to list notes");
        System.out.println("[exit] to exit");
    }

}
