package notes;

import notes.modules.Module;

import java.util.ArrayList;
import java.util.Scanner;

public class ModulesList {
    static ModulesList instance = null;
    private ArrayList<Module> modules;

    private ModulesList() {
        this.modules = new ArrayList<>();
    }

    /**
     * Singleton check for null instance before initializing.
     * @return ModuleList
     */
    public static ModulesList getInstance() {
        if (instance == null) {
            instance = new ModulesList();
        }
        return instance;
    }

    /**
     * Create a module with code and name.
     */
    public void createModule() {
        Scanner input = new Scanner(System.in);
        String code;
        String name;
        code = input.nextLine().toUpperCase();
        name = input.nextLine();
        Module module = new Module(code, name);
        modules.add(module);
        String success = String.format("%s %s has been created\n", code, name);
        System.out.println(success);
    }

    /**
     * Delete a module using its code.
     */
    public void deleteModule() {
        Scanner input = new Scanner(System.in);
        String code;
        code = input.nextLine().toUpperCase();

        try {
            boolean isRemoved = modules.removeIf(mod -> mod.getCode().equals(code));
            if (isRemoved) {
                System.out.println(code + " has been removed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
