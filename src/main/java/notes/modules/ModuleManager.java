package notes.modules;

import java.util.Scanner;

public class ModuleOperators {
    public String generateNote() {
        Scanner input = new Scanner(System.in);
        String note = input.nextLine();
        return note;
    }

    public int getIndex() {
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        return index;
    }
}
