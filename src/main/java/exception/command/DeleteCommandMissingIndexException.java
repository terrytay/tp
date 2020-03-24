package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class DeleteCommandMissingIndexException extends CustomException {
    public DeleteCommandMissingIndexException() {
        super("Index to delete not mentioned");
    }
}