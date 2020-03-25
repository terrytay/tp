package notes;


import java.util.Scanner;

public class Notes {
    ModulesList modulesList;

    public Notes() {
        modulesList = ModulesList.getInstance();
    }

    /**
     * Creates a module.
     */
    public void createModule() {
        System.out.println("Please enter the module code: ");

        Scanner input = new Scanner(System.in);
        String code;
        String name;
        code = input.nextLine().toUpperCase();
        System.out.println("Please enter the module name: ");
        name = input.nextLine();

        modulesList.createModule(code, name);
    }

    /**
     * Deletes a module.
     */
    public void deleteModule() {
        System.out.println("Please enter the module code: ");

        Scanner input = new Scanner(System.in);
        String code;
        code = input.nextLine().toUpperCase();

        modulesList.deleteModule(code);
    }

    /**
     * To enter into the module notes.
     */
    public void enterModule() {
        System.out.println("Please enter the module code: ");

        Scanner input = new Scanner(System.in);
        String code = input.nextLine().toUpperCase();

        modulesList.enterModule(code);

    }

    //    public void importModules() {
    //
    //    }
    //
    //    public void exportModules() {
    //
    //    }

    /**
     * Print all saved modules.
     */
    public void listModules() {
        System.out.println("______________________________");
        modulesList.listModules();
        System.out.println("______________________________");
    }
}
