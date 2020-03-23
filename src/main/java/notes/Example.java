package notes;

import java.util.Scanner;



public class Example {

    /**
     * Prototype of note taking feature.
     * 0: create module, 1: delete module.
     * @param args just ignore this.
     */
    public static void main(String[] args) {
        Notes notes = new Notes();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice != 2) {
            switch (choice) {
            case 0:
                notes.createModule();
                break;
            case 1:
                notes.deleteModule();
                break;
            default:
                break;
            }
            choice = input.nextInt();

        }
    }
}
