package ui;

import java.io.File;

/**
 * This class contains all the constants required for Ui.
 */
public class Constants {
    public static final String FILE_PATH_STUDYAREAS = "library" + File.separator + "locations.txt";
    public static final String FILE_PATH_DICTIONARY = "library" + File.separator + "dictionary.txt";
    public static final String MISSING_STUDY_AREA_DATA = "locations.txt is missing";
    public static final String BYE_COMMAND = "bye";
    public static final String BYE_MESSAGE = "Bye!!!!!!";
    public static final String LINE = "_______________________________________________________________________________"
            + "_________________";
    public static final int MAX_LINE_LENGTH = 58;
    public static final String FLAG = "-";
    public static final String MULTIPLE_WHITE_SPACES = "\\s+";
    public static final String DUPLICATE_FLAGS = "Duplicate flags entered!";
    public static final String SIZE_FLAG = "-s";
    public static final String PORTS_FLAG = "-p";
    public static final String INDOOR_FLAG = "-i";
    public static final String OUTDOOR_FLAG = "-o";
    public static final String NOT_INTEGER = "Argument used after size flag \"-s\" is not an integer";
    public static final String WRONG_FLAG_USAGE = "Flags indicated are wrongly used. Please enter \"help\" for the"
            + " supported flags!";
    public static final String SPACE = " ";
    public static final String WRONG_FLAG_ARGUMENT_POSITION = "Flags are to be used only after location";
    public static final String START_STUDY_AREA_SEARCH = "Please enter the location for your desired study area. "
            + "Enter \"help\" for a list of supported flags. Flags should only come after location, if a criteria for"
            + " location is entered. When you are done with the search, enter \"bye\".";
    public static final String PROMPT_USER = "Please enter the location for your desired study area.";
    public static final String FLAGS = "\t Here is a list of supported flags!" + System.lineSeparator()
            + "\t -p for study"
            + " areas with ports" + System.lineSeparator() + "\t -i for study areas that are indoors"
            + System.lineSeparator() + "\t -o for study areas that are outdoors" + System.lineSeparator() + "\t "
            + "-s {size} for maximum number of pax";
    public static final String AVAILABLE_STUDY_AREAS = "Here are the available study areas!";
    public static final String EMPTY_LIST = "Oops! Based on your criteria we were not able to find a compatible study"
            + " area!";
    public static final String ONLY_FLAG = "Please enter the flag along with \"-\"";
    public static final String INCONSISTENT_DATA_STORAGE = "Data is wrongly stored in locations.txt";
    public static final String HELP_COMMAND = "help";
    public static final String TAB = "\t ";
    public static final String NO_SIZE_INDICATED = "Max Size is not indicated. Please indicate accordingly!";
    public static final String END_MESSAGE = "Thank you for using our study area search service!";
    public static final String START_MESSAGE = "Welcome to OrgaNice! To start, enter \"task\" to start"
            + " your task list! If you are in the mood to mug and you"
            + " want to start your study area list, enter \"study\" !If"
            + " you want to exit, enter \"bye\" !";
    public static final String WRONG_INPUT = "Wrong input! Please enter either \"task\" or \"study\" only!";
    public static final String TASK_COMMAND = "task";
    public static final String STUDY_COMMAND = "study";
    public static final String GOODBYE_MESSAGE = "  Goodbye! Hope to see you again!";
    public static final String INTERMEDIATE_MESSAGE = "Please enter \"task\" to continue with your event list or"
            + " \"study\" to continue with your study area list. To leave, enter \"bye\".";
    public static final String EMPTY_LOCATION = "Location entered is empty! Please type a location to search for "
            + "StudyAreas!";
    public static final String NON_POSITIVE_INTEGER = "Integer entered cannot be zero or negative!";
    public static final String HELP_DESCRIPTION_20 = TAB + "*There are 4 levels of priority, with 1 being the most "
            + "urgent, and 4 being the least urgent";
    public static final String HELP_DESCRIPTION_19 = TAB + "*All timing should follow 24 hour clock";
    public static final String HELP_DESCRIPTION_18 = TAB + "*All dates should follow YYYY-MM-DD format";
    public static final String HELP_DESCRIPTION_17 = TAB + "Notes:";
    public static final String HELP_DESCRIPTION_16 = TAB + "bye --------------------------------------- Terminate task"
            + " interface";
    public static final String HELP_DESCRIPTION_15 = TAB + "help -------------------------------------- View List Of "
            + "Commands Supported";
    public static final String HELP_DESCRIPTION_14 = TAB + "edit <index number of task> --------------- Edit the task";
    public static final String HELP_DESCRIPTION_13 = TAB + "delete <index number of task> ------------- Delete the "
            + "task";
    public static final String HELP_DESCRIPTION_12 = TAB + "search <keyword found in task> ------------ View existing "
            + "task that contains the keyword";
    public static final String HELP_DESCRIPTION_11 = TAB + "clear ------------------------------------- Delete"
            + " all tasks";
    public static final String HELP_DESCRIPTION_10 = TAB + "countdown --------------------------------- View existing"
            + " tasks based on days left";
    public static final String HELP_DESCRIPTION_9 = TAB + "priority_view ----------------------------- View existing "
            + "tasks based on priority";
    public static final String HELP_DESCRIPTION_8 = TAB + "view -------------------------------------- View existing"
            + " events";
    public static final String HELP_DESCRIPTION_7 = TAB + "------------------------------------------- Create a new "
            + "deadline";
    public static final String HELP_DESCRIPTION_5 = TAB + "deadline <deadline details> /d <date> /t <due time> /p "
            + "<priority of deadline>";
    public static final String HELP_DESCRIPTION_4 = TAB + "------------------------------------------- Create a new "
            + "event";
    public static final String HELP_DESCRIPTION_3 = TAB + "event <event details> /d <date> /s <start time> "
            + "/e <end time> /p <priority of event>";
    public static final String HELP_DESCRIPTION_2 = TAB + "Please enter the keywords followed by the information"
            + " shown in the brackets";
    public static final String HELP_DESCRIPTION_1 = TAB + "OrgaNice! Supports the following commands";
    //@@author NizarMohd-reused
    //Reused from https://www.netclipart.com/isee/iRwmhJb_bt21-rj-transparent-background/ and https://asciiart.club/
    //Image for public static final String DAB is obtained from the first link and then generated in second link.
    public static final String DAB = "\t ``````````````````````````````````````````````````````````"
            + System.lineSeparator()
            + "\t ````````````````````````````````:v(v'`````````````````````" + System.lineSeparator()
            + "\t ```````````````````````````,)4|ex` `L}````````````````````" + System.lineSeparator()
            + "\t `````````````````````````!s\"'h `M:   ^z_;)T```````````````" + System.lineSeparator()
            + "\t `````````````````````````Z   u|}Z:        \"}``````````````" + System.lineSeparator()
            + "\t ``````````````````````:=?)                'B?L'```````````" + System.lineSeparator()
            + "\t `````````````````````'Z                    ;Yp\"```````````" + System.lineSeparator()
            + "\t `````````````````````.e                      ?_```````````" + System.lineSeparator()
            + "\t ```````````````````'QDGH                    .5````````````" + System.lineSeparator()
            + "\t ````````````````````I#g'         '_`        ||````````````" + System.lineSeparator()
            + "\t ```````````:mX_``````YhL`      `'q!`   ?     h````````````" + System.lineSeparator()
            + "\t ```````````'Qbs)|L=_V\" 'Y}     ^'q@&b=c=_`  ,Z````````````" + System.lineSeparator()
            + "\t ````````````q>     'T,   ,o\"    ;\"@c.   .sVx~`````````````" + System.lineSeparator()
            + "\t ````````````c!             \"bh` `,p       z:``````````````" + System.lineSeparator()
            + "\t `````````````q.              ngDQmh8s     X'``````````````" + System.lineSeparator()
            + "\t ``````````````LY\"             :n}>``b;   _V```````````````" + System.lineSeparator()
            + "\t ````````````````q?,                ?;   \"V````````````````" + System.lineSeparator()
            + "\t ``````````````KvR                  '  )x_`````````````````" + System.lineSeparator()
            + "\t ``````````````zjL                  GLY\"```````````````````" + System.lineSeparator()
            + "\t ```````````````M                 .I)``````````````````````" + System.lineSeparator()
            + "\t ```````````````Lz                `D:``````````````````````" + System.lineSeparator()
            + "\t ``````````````vu`    (I)_;\"\".      P.`````````````````````" + System.lineSeparator()
            + "\t ``````````````p     :X.':^,\"=n    \"q``````````````````````" + System.lineSeparator()
            + "\t `````````````)0X?^:)I````````m'   :j``````````````````````" + System.lineSeparator()
            + "\t `````````````.IGD8k'`````````<&G55M```````````````````````" + System.lineSeparator()
            + "\t ``````````````````````````````````````````````````````````";
    //@@author

    //@@author NizarMohd-reused
    //Reused logo from http://patorjk.com/software/taag/#p=display&f=Graffiti&t=TypeSomething with minor
    // modifications. The website above allows for generation of fonts in ascii format. Therefore, logo is
    // generated from the service provided by the website.
    public static final String LOGO = "_______/\\\\\\\\\\___________________________________________________"
        + "__/\\\\\\\\\\_____/\\\\\\__"
        + "__________________________________________/\\\\\\____________" +  System.lineSeparator()
        + "______/\\\\\\///\\\\\\__________________________________________________\\/\\\\\\\\\\\\___\\/\\\\\\_"
        + "_________________________________________/\\\\\\\\\\\\\\_________" +  System.lineSeparator()
        + "_____/\\\\\\/__\\///\\\\\\____________________/\\\\\\\\\\\\\\\\___________________\\/\\\\\\/\\\\\\_"
        + "_\\/\\\\\\___/\\\\\\__________________________________/\\\\\\\\\\\\\\\\\\_______"
        +  System.lineSeparator()
        + "_____/\\\\\\______\\//\\\\\\___/\\\\/\\\\\\\\\\\\\\____/\\\\\\////\\\\\\___/\\\\\\\\\\\\\\\\\\___"
        + "__\\/\\\\\\//\\\\\\_\\/\\\\\\__\\///_______/\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\__"
        + "_\\//\\\\\\\\\\\\\\_______" +  System.lineSeparator()
        + "_____\\/\\\\\\_______\\/\\\\\\__\\/\\\\\\/////\\\\\\__\\//\\\\\\\\\\\\\\\\\\__\\////////\\\\\\___"
        + "_\\/\\\\\\\\//\\\\\\\\/\\\\\\___/\\\\\\____/\\\\\\//////_____/\\\\\\/////\\\\\\___\\//\\\\\\\\\\____"
        + "___" +  System.lineSeparator()
        + "______\\//\\\\\\______/\\\\\\___\\/\\\\\\___\\///____\\///////\\\\\\____/\\\\\\\\\\\\\\\\\\\\__"
        + "_\\/\\\\\\_\\//\\\\\\/\\\\\\__\\/\\\\\\___/\\\\\\___________/\\\\\\\\\\\\\\\\\\\\\\_____\\//\\\\\\__"
        + "_____" +  System.lineSeparator()
        + "________\\///\\\\\\__/\\\\\\_____\\/\\\\\\___________/\\\\_____\\\\\\___/\\\\\\/////\\\\\\__"
        + "_\\/\\\\\\__\\//\\\\\\\\\\\\__\\/\\\\\\__\\//\\\\\\_________\\//\\\\///////_______\\///_______"
        +  System.lineSeparator()
        + "____________\\///\\\\\\\\\\/______\\/\\\\\\__________\\//\\\\\\\\\\\\\\\\__"
        + "_\\//\\\\\\\\\\\\\\\\/\\\\"
        + "_\\/\\\\\\___\\//\\\\\\\\\\__\\/\\\\\\___\\///\\\\\\\\\\\\\\\\___\\//\\\\\\\\\\\\\\\\\\\\_____"
        + "_/\\\\\\_____" +  System.lineSeparator()
        + "______________\\/////________\\///____________\\////////_____\\////////\\//___\\///_____\\/////__"
        +  "_\\///______\\////////_____\\//////////______\\///_____";
    //@@author

    public static final String NON_POSITIVE_INTEGER_LOG = "User entered a non positive integer";
    public static final String NON_INTEGER_LOG = "User entered an invalid number for integer input";

    public static final String DUPLICATE_FLAGS_LOG = "Duplicate flags entered by user";
    public static final String IDENTIFIER_MISSING_LOG = "Identifier not entered with flag by user";
    public static final String NO_SIZE_INDICATED_LOG = "no string exist after \"-s\"";
    public static final String WRONG_FLAG_LOG = "Wrong flag used by user while searching for study areas";
    public static final String FLAG_MISPLACED_LOG = "Flag is placed in the wrong position in the user input";
    public static final String NEW_TASK_ADDED_MESSAGE = "A new task with the following information has been added.";
    public static final String TASK_LIST_AS_FOLLOWS = "Here is the list of tasks added so far:";
    public static final String CLOSING_BRACKET = ") ";
    public static final String LIST_EMPTY_MESSAGE = "The list is empty.";
    public static final String TASK_AT_INDEX_DELETED_MESSAGE = "The task at the mentioned index has been deleted";
    public static final String INDEX_TO_BE_DELETED_OUT_OF_BOUNDS_LOG = "Index specified to be deleted is out of bounds";
    public static final String RE_ENTER_VALID_INDEX_TO_DELETE_MESSAGE = "Invalid index entered. Please enter a valid"
            + " index to be deleted";
    public static final String TASK_AT_INDEX_EDITED_MESSAGE = "The task at the mentioned index has been "
            + "edited successfully";
    public static final String RE_ENTER_VALID_INDEX_TO_EDIT_MESSAGE = "Invalid index entered. Please enter a"
            + " valid index to be edited";
    public static final String INVALID_TASK_TYPE_LOG = "Task type of the task to be edited not recognized";
    public static final String ERROR_ENCOUNTERED_DURING_EXECUTION_MESSAGE = "Error encountered during execution";
    public static final String TASK_LIST_CLEARED_MESSAGE = "The list of tasks is cleared.";
    public static final String LIST_SORTED_BY_PRIORITY_MESSAGE = "Here is the list of tasks added so far displayed "
            + "in decreasing order of priority:";
    public static final String LIST_SORTED_ON_DAYS_LEFT_MESSAGE = "Here is the list of tasks with sorted based"
            + " on the number of days left:";
    public static final String ARROW_SYMBOL = " ---> ";
    public static final String DAYS_LEFT = " day(s) left";
}