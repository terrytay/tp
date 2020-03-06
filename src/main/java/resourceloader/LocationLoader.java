package resourceloader;

import studyarea.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LocationLoader implements Loader {
    private static final String DIVIDER = "  ";
    private final String url;
    private File file;

    public LocationLoader(String url) throws FileNotFoundException {
        this.url = url;
        loadFile();
    }

    @Override
    public void loadFile() throws FileNotFoundException {
        try {
            file = new File(url);
        } catch (Exception e) {
            throw new FileNotFoundException("File not found.");
        }
    }

    @Override
    public File getFile() {
        return this.file;
    }

    /**
     * Return the imported study area file as an ArrayList for the main controller
     * to add it to its database.
     *
     * @return buffer ArrayList of Location from study area file
     * @throws Exception to be edited
     */
    public ArrayList<Location> pushToDatabase() throws Exception {
        ArrayList<Location> buffer = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String detailsOfLocation = input.nextLine();
            String[] detailsBuffer = detailsOfLocation.split(DIVIDER);
            Location location = new Location(detailsBuffer[0], detailsBuffer[1], detailsBuffer[2],
                    Boolean.parseBoolean(detailsBuffer[3]), Boolean.parseBoolean(detailsBuffer[4]),
                    Integer.parseInt(detailsBuffer[5]));
            buffer.add(location);
        }
        return buffer;
    }
}