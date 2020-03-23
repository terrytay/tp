package exception;

/**
 * This is an extension of the Exception class that exist only for StudyArea related modules.
 */
//@@author NizarMohd
public class IllegalStudyAreaException extends Exception {
    //@@author NizarMohd
    public IllegalStudyAreaException(String message) {
        super(message);
    }
}