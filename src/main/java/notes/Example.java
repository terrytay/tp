package notes;

import java.util.Scanner;



public class Example {

    /**
     * Prototype of note taking feature based on modules.
     * @param args just ignore this.
     */
    public static void main(String[] args) {
        Notes notes = new Notes();
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            System.out.println("[add] to add a module");
            System.out.println("[remove] to remove a module");
            System.out.println("[enter] to choose a module to enter notes");
            System.out.println("[list] to list modules");
            System.out.println("[exit] to exit");
            choice = input.nextLine();
            switch (choice) {
            case "add":
                notes.createModule();
                break;
            case "remove":
                notes.deleteModule();
                break;
            case "enter":
                notes.enterModule();
                break;
            case "list":
                notes.listModules();
                break;
            case "exit":
                break;
            default:
            }

        } while (!choice.equals("exit"));
    }
}
