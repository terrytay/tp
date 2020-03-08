package studyarea;

import resourceloader.StudyAreaLoader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static studyarea.Utility.DUPLICATE_FLAGS;
import static studyarea.Utility.FLAG;
import static studyarea.Utility.INDOOR_FLAG;
import static studyarea.Utility.MULTIPLE_WHITE_SPACES;
import static studyarea.Utility.NOT_INTEGER;
import static studyarea.Utility.NO_SIZE_INDICATED;
import static studyarea.Utility.ONLY_FLAG;
import static studyarea.Utility.PORTS_FLAG;
import static studyarea.Utility.SIZE_FLAG;
import static studyarea.Utility.SPACE;
import static studyarea.Utility.WRONG_FLAG_ARGUMENT_POSITION;
import static studyarea.Utility.WRONG_FLAG_USAGE;

/**
 * This is the class that stores and manages all of the Study Areas in location.txt
 */

public class StudyAreaList {
    private ArrayList<StudyArea> studyAreaList;

    /**
     * Setup a resource loader to import the file by creating a new
     * LocationLoader class. The file is then load onto the software and then
     * parsed as an ArrayList to be stored in location in this StudyArea class.
     *
     * @throws FileNotFoundException to be edited
     */

    public StudyAreaList() throws FileNotFoundException, IllegalStudyAreaException {
        StudyAreaLoader studyAreaLoader = new StudyAreaLoader("library/locations.txt");
        studyAreaLoader.loadFile();
        this.studyAreaList = studyAreaLoader.pushToDatabase();
    }

    /**
     * Gets the list of all the Locations in location.txt
     *
     * @return ArrayList of StudyAreas.
     */

    public ArrayList<StudyArea> getStudyAreaList() {
        return this.studyAreaList;
    }

    /**
     * Obtains all the supported flags in this organiser app.
     *
     * @param commands This is the User commands that has been split by spaces.
     * @return String Array of a fixed size of 5
     * @throws IllegalStudyAreaException when arguments for flags are invalid.
     */

    public String[] getFlagsInfo(String[] commands) throws IllegalStudyAreaException {
        String[] flags = new String[5];
        StringBuilder name = new StringBuilder();
        boolean isNotFlag = true;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(SIZE_FLAG)) {
                isNotFlag = false;
                try {
                    int size = Integer.parseInt(commands[i + 1]);
                    if (flags[0] == null) {
                        flags[0] = SIZE_FLAG;
                        flags[1] = Integer.toString(size);
                    } else {
                        throw new IllegalStudyAreaException(DUPLICATE_FLAGS);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalStudyAreaException(NOT_INTEGER);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new IllegalStudyAreaException(NO_SIZE_INDICATED);
                } finally {
                    i++;
                }
            } else if (commands[i].contains(FLAG)) {
                isNotFlag = false;
                if (commands[i].length() == 1) {
                    throw new IllegalStudyAreaException(ONLY_FLAG);
                }
                switch (commands[i].charAt(1)) {
                case 'p':
                    if (flags[2] == null) {
                        flags[2] = PORTS_FLAG;
                    } else {
                        throw new IllegalStudyAreaException(DUPLICATE_FLAGS);
                    }
                    break;
                case 'i':
                    if (flags[3] == null) {
                        flags[3] = INDOOR_FLAG;
                    } else {
                        throw new IllegalStudyAreaException(DUPLICATE_FLAGS);
                    }
                    break;
                default:
                    throw new IllegalStudyAreaException(WRONG_FLAG_USAGE);
                }
            } else {
                if (isNotFlag) {
                    name.append(commands[i]).append(SPACE);
                    flags[4] = name.toString().trim();
                } else {
                    throw new IllegalStudyAreaException(WRONG_FLAG_ARGUMENT_POSITION);
                }
            }
        }
        return flags;
    }

    /**
     * Checks if search key is found in Study Area's Name and Faculty attributes.
     * @param name This is the Study Area's Name Attribute.
     * @param faculty This is the Study Area's Faculty Attribute.
     * @param key This is the search key entered by User.
     * @return True if can be found in either case. False if not found in both cases.
     */

    public static boolean containsKey(String name, String faculty, String key) {
        if (name.toLowerCase().contains(key.toLowerCase())) { //toLowerCase() so casing does not affect matching.
            return true;
        }
        return faculty.toLowerCase().contains(key.toLowerCase()); // if first check is false, return true depends on
        // second check.
    }

    /**
     * Finds a list of StudyAreas based on User requirements.
     *
     * @param userIn This is the requirement entered by User
     * @return ArrayList of StudyAreas
     */

    public ArrayList<StudyArea> searchList(String userIn) throws IllegalStudyAreaException {
        String[] temp = userIn.split(MULTIPLE_WHITE_SPACES);
        String[] flags = getFlagsInfo(temp);
        ArrayList<StudyArea> availStudyAreas = new ArrayList<>();
        for (StudyArea studyArea : this.studyAreaList) {
            boolean isAvail = true;
            for (String flag : flags) {
                if (flag != null && isAvail) {
                    switch (flag) {
                    case PORTS_FLAG:
                        isAvail = isAvail && studyArea.hasPort();
                        break;
                    case INDOOR_FLAG:
                        isAvail = isAvail && studyArea.isIndoor();
                        break;
                    case SIZE_FLAG:
                        boolean isMaxPax = flags[1].equals(studyArea.getMaxPax().toString());
                        isAvail = isAvail && isMaxPax;
                        break;
                    default:
                        isAvail = isAvail && containsKey(studyArea.getName(), studyArea.getFaculty(), flags[4]);
                        break;
                    }
                }
            }
            if (isAvail) {
                availStudyAreas.add(studyArea);
            }
        }
        return availStudyAreas;
    }
}
