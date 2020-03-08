package studyarea;

import java.util.StringTokenizer;

/**
 * This class holds all the Utilities required for the Study Area related classes.
 */

public class Utility {
    public static final int MAX_LINE_LENGTH = 55;
    public static final int ADDRESS_MAX_LENGTH = 48;
    public static final String FLAG = "-";
    public static final String MULTIPLE_WHITE_SPACES = "\\s+";
    public static final String DUPLICATE_FLAGS = "Duplicate flags entered!";
    public static final String SIZE_FLAG = "-s";
    public static final String PORTS_FLAG = "-p";
    public static final String INDOOR_FLAG = "-i";
    public static final String NOT_INTEGER = "Argument used after size flag \"-s\" is not an integer";
    public static final String WRONG_FLAG_USAGE = "Flags indicated are wrongly used. Please enter \"help\" for the"
            + " supported flags!";
    public static final String SPACE = " ";
    public static final String WRONG_FLAG_ARGUMENT_POSITION = "Flags are to be used only after location";
    public static final String START_STUDY_AREA_SEARCH = "Please enter the location for your desired study area. "
            + "Enter \"help\" for a list of supported flags. Flags should only come after location, if a criteria for"
            + " location is entered. When you are done with the search, enter \"end\".";
    public static final String PROMPT_USER = "Please enter the location for your desired study area.";
    public static final String FLAGS = "\t Here is a list of supported flags!\n\t -p for study areas with ports\n\t"
            + " -i for study areas that are indoors\n\t -s {size} for maximum number of pax";
    public static final String AVAILABLE_STUDY_AREAS = "Here are the available study areas!";
    public static final String EMPTY_LIST = "Oops! Based on your criteria we were not able to find a compatible study"
            + "area!";
    public static final String ONLY_FLAG = "Please enter the flag along with \"-\"";
    public static final String INCONSISTENT_DATA_STORAGE = "Data is wrongly stored in locations.txt";
    public static final String END_COMMAND = "end";
    public static final String HELP_COMMAND = "help";
    public static final String TAB = "\t ";
    public static final String NO_SIZE_INDICATED = "Max Size is not indicated. Please indicate accordingly!";
    public static final String END_MESSAGE = "Thank you for using our study area search service!";

    /**
     * This method ensures that the message printed is within the standard<br>
     * length.
     * @param message is the String that we intend to format to a standard length<br>
     *                per line.<br>
     * @param maxLength This is the standard length intended to be formatted.
     * @return String of standard length per line
     */

    public static String formatMessage(String message, int maxLength) {
        StringTokenizer token = new StringTokenizer(message, SPACE);
        StringBuilder standardLengthMessage = new StringBuilder(message.length());
        int lineLength = 0;
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            if (lineLength + word.length() > maxLength) {
                standardLengthMessage.append("\n\t ");
                lineLength = 0;
            }
            standardLengthMessage.append(word).append(SPACE);
            lineLength += word.length() + 1;
        }
        return TAB + standardLengthMessage.toString().stripTrailing();
    }
}
