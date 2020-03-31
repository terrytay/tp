package exception;

//@@author NizarMohd
/**
 * This is the exception for when the user enters commands illegally when viewing the calender.
 */
public class CalenderException extends Exception {

    public CalenderException(String message) {
        super(message);
    }
}
