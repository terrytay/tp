package notes.modules;

import java.util.ArrayList;

public class Module {
    private String code;
    private String name;
    private ArrayList<String> notes;

    /**
     * Constructs a new Module class with code and name.
     * @param code e.g. cg1112, cs2107, cs2040c
     * @param name e.g. Computer Security, Competitive Programming in C++
     */
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
