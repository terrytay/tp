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
    public void createModule(String code) {
        code = code.toUpperCase();

        modulesList.createModule(code);
    }

    /**
     * Deletes a module.
     */
    public void deleteModule(String code) {
        code = code.toUpperCase();

        modulesList.deleteModule(code);
    }

    /**
     * To enter into the module notes.
     */
    public void enterModule(String code) {
        code = code.toUpperCase();

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
