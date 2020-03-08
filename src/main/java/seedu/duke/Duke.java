package seedu.duke;

import event.EventList;
import ui.Ui;

import java.util.Scanner;

public class Duke {

    public static Ui ui = new Ui();

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
    static EventList eventList = new EventList();

    /**
     * Main entry-point for the java.duke.Duke application.
     * @param args this is an optional argument.
     */
    public static void main(String[] args)  {
        String logo = "_______/\\\\\\\\\\_____________________________________________________/\\\\\\\\\\_____/\\\\\\__"
                + "__________________________________________/\\\\\\____________\n"
                + "______/\\\\\\///\\\\\\__________________________________________________\\/\\\\\\\\\\\\___\\/\\\\\\_"
                + "_________________________________________/\\\\\\\\\\\\\\_________\n"
                + "_____/\\\\\\/__\\///\\\\\\____________________/\\\\\\\\\\\\\\\\___________________\\/\\\\\\/\\\\\\_"
                + "_\\/\\\\\\___/\\\\\\__________________________________/\\\\\\\\\\\\\\\\\\_______\n"
                + "_____/\\\\\\______\\//\\\\\\___/\\\\/\\\\\\\\\\\\\\____/\\\\\\////\\\\\\___/\\\\\\\\\\\\\\\\\\___"
                + "__\\/\\\\\\//\\\\\\_\\/\\\\\\__\\///_______/\\\\\\\\\\\\\\\\______/\\\\\\\\\\\\\\\\__"
                + "_\\//\\\\\\\\\\\\\\_______\n"
                + "_____\\/\\\\\\_______\\/\\\\\\__\\/\\\\\\/////\\\\\\__\\//\\\\\\\\\\\\\\\\\\__\\////////\\\\\\___"
                + "_\\/\\\\\\\\//\\\\\\\\/\\\\\\___/\\\\\\____/\\\\\\//////_____/\\\\\\/////\\\\\\___\\//\\\\\\\\\\____"
                + "___\n"
                + "______\\//\\\\\\______/\\\\\\___\\/\\\\\\___\\///____\\///////\\\\\\____/\\\\\\\\\\\\\\\\\\\\__"
                + "_\\/\\\\\\_\\//\\\\\\/\\\\\\__\\/\\\\\\___/\\\\\\___________/\\\\\\\\\\\\\\\\\\\\\\_____\\//\\\\\\__"
                + "_____\n"
                + "________\\///\\\\\\__/\\\\\\_____\\/\\\\\\___________/\\\\_____\\\\\\___/\\\\\\/////\\\\\\__"
                + "_\\/\\\\\\__\\//\\\\\\\\\\\\__\\/\\\\\\__\\//\\\\\\_________\\//\\\\///////_______\\///_______\n"
                + "____________\\///\\\\\\\\\\/______\\/\\\\\\__________\\//\\\\\\\\\\\\\\\\__"
                + "_\\//\\\\\\\\\\\\\\\\/\\\\"
                + "_\\/\\\\\\___\\//\\\\\\\\\\__\\/\\\\\\___\\///\\\\\\\\\\\\\\\\___\\//\\\\\\\\\\\\\\\\\\\\_____"
                + "_/\\\\\\_____\n"
                + "______________\\/////________\\///____________\\////////_____\\////////\\//___\\///_____\\/////__"
                +  "_\\///______\\////////_____\\//////////______\\///_____";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
        runCommands();
    }

    private static void runCommands() {
        Scanner in = new Scanner(System.in);
        String command;
        command = in.nextLine();
        while (!command.equals(BYE_COMMAND)) {
            try {
                String commandType = command.split(" ")[0];
                switch (commandType) {
                case ADD_COMMAND:
                    eventList.add(command);
                    break;
                case VIEW_COMMAND:
                    eventList.listEvents();
                    break;
                case PRIORITY_VIEW_COMMAND:
                    eventList.priorityView();
                    break;
                case COUNTDOWN_VIEW_COMMAND:
                    eventList.countdownView();
                    break;
                case CLEAR_COMMAND:
                    eventList.clearEvents();
                    break;
                case SEARCH_COMMAND:
                    eventList.searchEvents(command.split(" ", 2)[1]);
                    break;
                case DELETE_COMMAND:
                    eventList.deleteEvent(Integer.parseInt(command.split(" ", 2)[1]));
                    break;
                default:
                    ui.printLine();
                    System.out.println(INVALID_COMMAND_MESSAGE);
                    ui.printLine();
                    break;
                }
            } catch (NumberFormatException e) {
                ui.printLine();
                System.out.println(INVALID_INDEX_MESSAGE);
                ui.printLine();
            } catch (IndexOutOfBoundsException e) {
                ui.printLine();
                System.out.println(INVALID_COMMAND_MESSAGE);
                ui.printLine();
            }
            command = in.nextLine();
        }
        System.out.println(BYE_MESSAGE);
    }
}
