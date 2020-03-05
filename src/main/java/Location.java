public class Location {
    private String name;
    private String address;
    private String faculty;
    private boolean hasPort;
    private boolean isIndoor;
    private int maxPax;

    public Location(String name, String address, String faculty, boolean hasPort, boolean isIndoor, int maxPax) {
        this.name = name;
        this.address = address;
        this.faculty = faculty;
        this.hasPort = hasPort;
        this.isIndoor = isIndoor;
        this.maxPax = maxPax;
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
