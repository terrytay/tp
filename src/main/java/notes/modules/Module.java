package notes.modules;

import java.util.ArrayList;

public class Module {
    private String code;
    private String name;
    private ArrayList<String> notes;

    public Module(String code, String name) {
        this.code = code;
        this.name = name;
        this.notes = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
