package exception;

public class NotesCommandException extends CustomException {

    public static final String ENTER_A_VALID_COMMAND = "Please enter a valid command. e.g. To add a module, enter"
            + " \"add [modulename]\"";

    public NotesCommandException() {
        super(ENTER_A_VALID_COMMAND);
    }
}
