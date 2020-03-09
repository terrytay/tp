package ui;

/**
 * Contains functions used to interact with the user.
 */
public class Ui {

    /**
     * Prints a line made up of '_'.
     */
    public void printLine() {
        System.out.println("____________________________________________________________________________________");
    }

    public void printWithIndentation(String line) {
        System.out.println("    " + line);
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
