package command;

import event.EventList;
import ui.Ui;

import java.util.Scanner;

public class EventCommand {

    /**
     * Commands for Events.
     *
     * @param eventList evenList
     */
    public static void runCommands(EventList eventList) {
        Scanner in = new Scanner(System.in);
        String command;
        command = in.nextLine();
        while (!command.equals(Ui.BYE_COMMAND)) {
            try {
                String commandType = command.split(" ")[0];
                switch (commandType) {
                case Ui.ADD_COMMAND:
                    eventList.add(command);
                    break;
                case Ui.VIEW_COMMAND:
                    eventList.listEvents();
                    break;
                case Ui.PRIORITY_VIEW_COMMAND:
                    eventList.priorityView();
                    break;
                case Ui.COUNTDOWN_VIEW_COMMAND:
                    eventList.countdownView();
                    break;
                case Ui.CLEAR_COMMAND:
                    eventList.clearEvents();
                    break;
                case Ui.SEARCH_COMMAND:
                    eventList.searchEvents(command.split(" ", 2)[1]);
                    break;
                case Ui.DELETE_COMMAND:
                    eventList.deleteEvent(Integer.parseInt(command.split(" ", 2)[1]));
                    break;
                default:
                    Ui.printLine();
                    System.out.println(Ui.INVALID_COMMAND_MESSAGE);
                    Ui.printLine();
                    break;
                }
            } catch (NumberFormatException e) {
                Ui.printLine();
                System.out.println(Ui.INVALID_INDEX_MESSAGE);
                Ui.printLine();
            } catch (IndexOutOfBoundsException e) {
                Ui.printLine();
                System.out.println(Ui.INVALID_COMMAND_MESSAGE);
                Ui.printLine();
            }
            command = in.nextLine();
        }
        System.out.println(Ui.BYE_MESSAGE);
    }
}
