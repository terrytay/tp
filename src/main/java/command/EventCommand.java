package command;

import event.EventList;
import resourceloader.EventLoader;
import ui.Ui;

import java.util.Scanner;

public class EventCommand {

    /**
     * Commands for Events.
     *
     * @param eventList this is the evenList.
     * @param ui allows for interaction with the User.
     * @param eventLoader allows for saving of data after every execution of commands.
     */
    public static void runCommands(EventList eventList, Ui ui, EventLoader eventLoader) {
        Scanner in = new Scanner(System.in);
        String command;
        ui.printLine();
        command = in.nextLine();
        while (!command.equals(Ui.BYE_COMMAND)) {
            ui.printLine();
            try {
                String commandType = command.split(" ")[0];
                switch (commandType) {
                case Ui.ADD_COMMAND:
                    eventList.add(command, ui);
                    break;
                case Ui.VIEW_COMMAND:
                    eventList.listEvents(ui);
                    break;
                case Ui.PRIORITY_VIEW_COMMAND:
                    eventList.priorityView(ui);
                    break;
                case Ui.COUNTDOWN_VIEW_COMMAND:
                    eventList.countdownView(ui);
                    break;
                case Ui.CLEAR_COMMAND:
                    eventList.clearEvents(ui);
                    break;
                case Ui.SEARCH_COMMAND:
                    eventList.searchEvents(command.split(" ", 2)[1], ui);
                    break;
                case Ui.DELETE_COMMAND:
                    eventList.deleteEvent(Integer.parseInt(command.split(" ", 2)[1]), ui);
                    break;
                default:
                    ui.printMessage(Ui.INVALID_COMMAND_MESSAGE);
                    break;
                }
            } catch (NumberFormatException e) {
                ui.printMessage(Ui.INVALID_INDEX_MESSAGE);
            } catch (IndexOutOfBoundsException e) {
                ui.printMessage(Ui.INVALID_COMMAND_MESSAGE);
            }
            ui.printLine();
            eventLoader.saveEvents(eventList.events);
            command = in.nextLine();
        }
        ui.printLine();
        ui.printMessage(Ui.BYE_MESSAGE);
        ui.printLine();
    }
}