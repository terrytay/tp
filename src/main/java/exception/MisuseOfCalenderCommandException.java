package exception;

//@@author NizarMohd
/**
 * This exception handles with when the user enters the calender command wrongly.
 */
public class MisuseOfCalenderCommandException extends CustomException {
    public MisuseOfCalenderCommandException() {
        super("Wrong command used for calender command. (Should be :calender )");
    }
}
