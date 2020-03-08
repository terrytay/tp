package resourceloader;

import studyarea.IllegalStudyAreaException;
import studyarea.StudyArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static studyarea.Utility.INCONSISTENT_DATA_STORAGE;

/**
 * This class loads all the required information of Study Areas that is stored in location.txt.
 */

public class StudyAreaLoader implements Loader {
    private static final String DIVIDER = "~";
    private final String url;
    private File file;

    public StudyAreaLoader(String url) throws FileNotFoundException {
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
     * @throws FileNotFoundException if location.txt does not exist.
     */

    public ArrayList<StudyArea> pushToDatabase() throws FileNotFoundException, IllegalStudyAreaException {
        ArrayList<StudyArea> buffer = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String detailsOfLocation = input.nextLine();
            String[] detailsBuffer = detailsOfLocation.split(DIVIDER);
            if (detailsBuffer.length != 6) {
                throw new IllegalStudyAreaException(INCONSISTENT_DATA_STORAGE);
            }
            StudyArea studyArea = new StudyArea(detailsBuffer[0], detailsBuffer[1], detailsBuffer[2],
                    Boolean.parseBoolean(detailsBuffer[3]), Boolean.parseBoolean(detailsBuffer[4]),
                    Integer.parseInt(detailsBuffer[5]));
            buffer.add(studyArea);
        }
        return buffer;
    }


}