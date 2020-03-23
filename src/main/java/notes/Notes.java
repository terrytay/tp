package notes;

public class Notes {
    ModulesList modulesList;
    public Notes() {
        modulesList = ModulesList.getInstance();
    }

    public void createModule() {
        modulesList.createModule();
    }

    public void deleteModule() {
        modulesList.deleteModule();
    }

    public void importNotes() {

    }

    public void exportNotes() {

    }
}
