package exception.command;

import exception.CustomException;

public class IndexNotIntegerException extends CustomException {
    public IndexNotIntegerException() {
        super("Enter a valid integer index (1-based) to delete the corresponding event \"\n" +
                " + \"(format: delete index)");
    }
}