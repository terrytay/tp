package notes.modules.command;

import notes.modules.ModuleManager;

public class AddCommand implements Command {
    ModuleManager moduleManager;
    String message;
    private String userCommandType;
    public AddCommand(ModuleManager moduleManager, String message,
                      String userCommandType) {
        this.moduleManager = moduleManager;
        this.message = message;
        this.userCommandType = userCommandType;
    }

    public AddCommand(ModuleManager moduleManager, String userCommandType) {
        this.moduleManager = moduleManager;
        this.userCommandType = userCommandType;
    }
    public void execute() {
        moduleManager.addMessage(message);
    }

    public void undo() {
        moduleManager.removeMessage(message);
    }

    public void redo() {
        execute();
    }

    public String getUserCommandType() {
        return userCommandType;
    }
}
