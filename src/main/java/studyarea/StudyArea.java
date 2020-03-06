package studyarea;

import resourceloader.LocationLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StudyArea {
    private ArrayList<Location> locations;

    /**
     * Setups a resource loader to import the file by creating a new
     * LocationLoader class. The file is then load onto the software and then
     * parsed as an ArrayList to be stored in location in this StudyArea class.

     * @throws Exception to be edited
     */
    public StudyArea() throws Exception {
        LocationLoader locationLoader = new LocationLoader("library/locations.txt");
        locationLoader.loadFile();
        locations = locationLoader.pushToDatabase();
    }

    public ArrayList<Location> getLocationsList() {
        return locations;
    }
}
