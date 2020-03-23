package notes;

import java.util.Scanner;

enum Choices {
    CREATE, DELETE;
}

public class Example {
    private static Choices cmd;

    public static void main(String[] args) {
        Notes notes = new Notes();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 2) {
            switch (choice) {
            case 0:
                cmd = Choices.CREATE;
                break;
            case 1:
                cmd = Choices.DELETE;
                break;
            default:
                break;
            }

            switch (cmd) {
            case CREATE:
                notes.createModule();
                break;
            case DELETE:
                notes.deleteModule();
                break;
            default:
                break;
            }
            choice = input.nextInt();

        }
    }
}
