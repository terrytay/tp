package studyarea;

import ui.Ui;

import static java.lang.System.lineSeparator;


/**
 * This is the Study Area class. All study area is stored as a Study Area object.
 */

public class StudyArea {
    private String name;
    private String address;
    private String faculty;
    private boolean hasPort;
    private boolean isIndoor;
    private int maxPax;

    /**
     * Constructs a Location class for a study area location with its information
     * Precondition: 'All variables have to be filled.
     *
     * @param name name of study location
     * @param address address of study location
     * @param faculty faculty of study location
     * @param hasPort true for availability of ports, else false
     * @param isIndoor true for indoor, else false
     * @param maxPax maximum number of seats for this study area
     */

    public StudyArea(String name, String address, String faculty, boolean hasPort,
                    boolean isIndoor, int maxPax) {
        this.name = name;
        this.address = Ui.formatMessage(address, Ui.ADDRESS_MAX_LENGTH).trim();
        this.faculty = faculty;
        this.hasPort = hasPort;
        this.isIndoor = isIndoor;
        this.maxPax = maxPax;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public boolean hasPort() {
        return this.hasPort;
    }

    public boolean isIndoor() {
        return this.isIndoor;
    }

    public Integer getMaxPax() {
        return this.maxPax;
    }

    /**
     * Prints the StudyArea into a standard String format.
     * @return String value of all the attributes of the specific StudyArea.
     */
    public String toString() {
        String text = Ui.TAB + "Name: " + this.name + lineSeparator() + Ui.TAB
                 + "Address: " + this.address + lineSeparator() + Ui.TAB
                 + "Faculty: " + this.faculty + lineSeparator() + Ui.TAB
                 + "Port: " + this.hasPort + lineSeparator() + Ui.TAB
                 + "Indoor: " + this.isIndoor + lineSeparator() + Ui.TAB
                 + "Average number of Pax: " + this.maxPax;
        String line = Ui.TAB + "__________________________________________________________";
        return line + lineSeparator() + text + lineSeparator() + line;
    }

}
