package ui;

import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.lineSeparator;

/**
 * Contains functions used to interact with the user.
 *
 */
public class Ui {
    private final Scanner in;
    private final PrintStream out;

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
    public static final String LINE = "_______________________________________________________________________________"
            + "_____";
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
            + " location is entered. When you are done with the search, enter \"bye\".";
    public static final String PROMPT_USER = "Please enter the location for your desired study area.";
    public static final String FLAGS = "\t Here is a list of supported flags!\n\t -p for study areas with ports\n\t"
            + " -i for study areas that are indoors\n\t -s {size} for maximum number of pax";
    public static final String AVAILABLE_STUDY_AREAS = "Here are the available study areas!";
    public static final String EMPTY_LIST = "Oops! Based on your criteria we were not able to find a compatible study"
            + "area!";
    public static final String ONLY_FLAG = "Please enter the flag along with \"-\"";
    public static final String INCONSISTENT_DATA_STORAGE = "Data is wrongly stored in locations.txt";
    public static final String HELP_COMMAND = "help";
    public static final String TAB = "\t ";
    public static final String NO_SIZE_INDICATED = "Max Size is not indicated. Please indicate accordingly!";
    public static final String END_MESSAGE = "Thank you for using our study area search service!";
    public static final String START_MESSAGE = "Welcome to OrgaNice! To start, enter \"event\" to start your event"
            + " list! If you are in the mood to mug and you want to start your study area list, enter \"study\" !"
            + "If you want to exit, enter \"bye\" !";
    public static final String WRONG_INPUT = "Wrong input! Please enter either \"event\" or \"study\" only!";
    public static final String EVENT_COMMAND = "event";
    public static final String STUDY_COMMAND = "study";
    public static final String GOODBYE_MESSAGE = "Goodbye! Hope to see you again!";
    public static final String INTERMEDIATE_MESSAGE = "Please enter \"event\" to continue with your event list or"
            + " \"study\" to continue with your study area list. To leave, enter \"bye\".";
    public static final String EMPTY_LOCATION = "Location entered is empty! Please type a location to search for "
            + "StudyAreas!";

    //@@author NizarMohd-reused
    //Reused from https://www.netclipart.com/isee/iRwmhJb_bt21-rj-transparent-background/ and https://asciiart.club/
    //Image for public static final String DAB is obtained from the first link and then generated in second link.
    public static final String DAB = "\t ``````````````````````````````````````````````````````````\n"
            + "\t ````````````````````````````````:v(v'`````````````````````\n"
            + "\t ```````````````````````````,)4|ex` `L}````````````````````\n"
            + "\t `````````````````````````!s\"'h `M:   ^z_;)T```````````````\n"
            + "\t `````````````````````````Z   u|}Z:        \"}``````````````\n"
            + "\t ``````````````````````:=?)                'B?L'```````````\n"
            + "\t `````````````````````'Z                    ;Yp\"```````````\n"
            + "\t `````````````````````.e                      ?_```````````\n"
            + "\t ```````````````````'QDGH                    .5````````````\n"
            + "\t ````````````````````I#g'         '_`        ||````````````\n"
            + "\t ```````````:mX_``````YhL`      `'q!`   ?     h````````````\n"
            + "\t ```````````'Qbs)|L=_V\" 'Y}     ^'q@&b=c=_`  ,Z````````````\n"
            + "\t ````````````q>     'T,   ,o\"    ;\"@c.   .sVx~`````````````\n"
            + "\t ````````````c!             \"bh` `,p       z:``````````````\n"
            + "\t `````````````q.              ngDQmh8s     X'``````````````\n"
            + "\t ``````````````LY\"             :n}>``b;   _V```````````````\n"
            + "\t ````````````````q?,                ?;   \"V````````````````\n"
            + "\t ``````````````KvR                  '  )x_`````````````````\n"
            + "\t ``````````````zjL                  GLY\"```````````````````\n"
            + "\t ```````````````M                 .I)``````````````````````\n"
            + "\t ```````````````Lz                `D:``````````````````````\n"
            + "\t ``````````````vu`    (I)_;\"\".      P.`````````````````````\n"
            + "\t ``````````````p     :X.':^,\"=n    \"q``````````````````````\n"
            + "\t `````````````)0X?^:)I````````m'   :j``````````````````````\n"
            + "\t `````````````.IGD8k'`````````<&G55M```````````````````````\n"
            + "\t ``````````````````````````````````````````````````````````";
    //@@author


    /**
     * This method ensures that the message printed is within the standard length.
     * @param message is the String that we intend to format to a standard length per line.
     * @param maxLength This is the standard length intended to be formatted.
     * @return String of standard length per line
     */

    //@@author NizarMohd-reused
    //Reused from https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java
    // with minor modification.
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
  
    /**
     * Display the list of supported commands.
     */
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
        System.out.println("search <keyword found in event> ----------- View existing events that contains "
                + "the keyword");
        System.out.println("delete <index number of event> ------------ Delete the event");
        System.out.println("bye --------------------------------------- Terminate program");
        System.out.println("Notes:");
        System.out.println("*All dates should follow YYYY-MM-DD format");
        System.out.println("*All timing should follow 24 hour clock");
        System.out.println("*There are 4 levels of priority, with 1 being the most urgent, and 4 being the "
                + "least urgent");
        printLine();
    }

    /**
     * Display welcome message.
     */
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
