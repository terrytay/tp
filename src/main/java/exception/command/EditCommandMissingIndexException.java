package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class EditCommandMissingIndexException extends CustomException {
    public EditCommandMissingIndexException() {
        super("Index to edited not mentioned");
    }
}