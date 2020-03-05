public class Location {
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
     *
     * @throws Exception when not all variables are filled
     */
    public Location(String name, String address, String faculty, boolean hasPort,
                    boolean isIndoor, int maxPax) throws Exception {
        try {
            this.name = name;
            this.address = address;
            this.faculty = faculty;
            this.hasPort = hasPort;
            this.isIndoor = isIndoor;
            this.maxPax = maxPax;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getFaculty() {
        return faculty;
    }

    public boolean hasPort() {
        return hasPort;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public int getMaxPax() {
        return maxPax;
    }
}
