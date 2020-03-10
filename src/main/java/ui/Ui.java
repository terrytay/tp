package ui;

import java.io.File;
import java.util.StringTokenizer;

/**
 * Contains functions used to interact with the user.
 */
public class Ui {
    public static final String FILE_PATH_EVENTS = "library" + File.separator + "eventList.txt";
    public static final String FILE_PATH_STUDYAREAS = "library" + File.separator + "locations.txt";

    public static final String ADD_COMMAND = "add";
    public static final String VIEW_COMMAND = "view";
    public static final String PRIORITY_VIEW_COMMAND = "priority_view";
    public static final String COUNTDOWN_VIEW_COMMAND = "countdown";
    public static final String CLEAR_COMMAND = "clear";
    public static final String SEARCH_COMMAND = "search";
    public static final String DELETE_COMMAND = "delete";
    public static final String INVALID_INDEX_MESSAGE = "Enter a valid index";
    public static final String INVALID_COMMAND_MESSAGE = "Enter a valid command";
    public static final String BYE_COMMAND = "bye";
    public static final String BYE_MESSAGE = "Bye!!!!!!";

    /**
     * Prints a line made up of '_'.
     */
    public static void printLine() {
        System.out.println("____________________________________________________________________________________");
    }

    public static void printWithIndentation(String line) {
        System.out.println("    " + line);
    }

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

    public void printHelp() {
        printLine();
        System.out.println("OrgaNice! Supports the following commands");
        System.out.println("Please enter the keywords followed by the information shown in the brackets");
        System.out.println("add <event details> /d <date> /s <start time> /e <end time> /p <priority of event>");
        System.out.println("------------------------------------------- Create a new event");
        System.out.println("view -------------------------------------- View existing events");
        System.out.println("priority_view ----------------------------- View existing events based on priority");
        System.out.println("countdown --------------------------------- View existing events based on days left");
        System.out.println("clear ------------------------------------- Delete all events");
        System.out.println("search <keyword found in event> ----------- View existing events that contains the keyword");
        System.out.println("delete <index number of event> ------------ Delete the event");
        System.out.println("bye --------------------------------------- Terminate program");
        System.out.println("Notes:");
        System.out.println("*All dates should follow YYYY-MM-DD format");
        System.out.println("*All timing should follow 24 hour clock");
        System.out.println("*There are 4 levels of priority, with 1 being the most urgent, and 4 being the least urgent");
        printLine();
    }

    public void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
    }
}
