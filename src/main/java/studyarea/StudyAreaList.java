package studyarea;

import ui.Ui;
import java.util.ArrayList;

/**
 * This is the class that stores and manages all of the Study Areas in location.txt
 */

public class StudyAreaList {
    private ArrayList<StudyArea> studyAreaList;

    // Assigns studyAreaList into object's studyAreaList.
    public StudyAreaList(ArrayList<StudyArea>  studyAreaList) {
        this.studyAreaList = studyAreaList;
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
            if (commands[i].equals(Ui.SIZE_FLAG)) {
                isNotFlag = false;
                try {
                    int size = Integer.parseInt(commands[i + 1]);
                    if (flags[0] == null) {
                        flags[0] = Ui.SIZE_FLAG;
                        flags[1] = Integer.toString(size);
                        i++;
                    } else {
                        throw new IllegalStudyAreaException(Ui.DUPLICATE_FLAGS);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalStudyAreaException(Ui.NOT_INTEGER);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new IllegalStudyAreaException(Ui.NO_SIZE_INDICATED);
                }
            } else if (commands[i].contains(Ui.FLAG)) {
                isNotFlag = false;
                if (commands[i].length() == 1) {
                    throw new IllegalStudyAreaException(Ui.ONLY_FLAG);
                }
                switch (commands[i].charAt(1)) {
                case 'p':
                    if (flags[2] == null) {
                        flags[2] = Ui.PORTS_FLAG;
                    } else {
                        throw new IllegalStudyAreaException(Ui.DUPLICATE_FLAGS);
                    }
                    break;
                case 'i':
                    if (flags[3] == null) {
                        flags[3] = Ui.INDOOR_FLAG;
                    } else {
                        throw new IllegalStudyAreaException(Ui.DUPLICATE_FLAGS);
                    }
                    break;
                default:
                    throw new IllegalStudyAreaException(Ui.WRONG_FLAG_USAGE);
                }
            } else {
                if (isNotFlag) {
                    name.append(commands[i]).append(Ui.SPACE);
                    flags[4] = name.toString().trim();
                } else {
                    throw new IllegalStudyAreaException(Ui.WRONG_FLAG_ARGUMENT_POSITION);
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
        try {
            String[] temp = userIn.split(Ui.MULTIPLE_WHITE_SPACES);
            String[] flags = getFlagsInfo(temp);
            ArrayList<StudyArea> availStudyAreas = new ArrayList<>();
            for (StudyArea studyArea : this.studyAreaList) {
                boolean isAvail = true;
                for (String flag : flags) {
                    if (flag != null && isAvail) {
                        switch (flag) {
                        case Ui.PORTS_FLAG:
                            isAvail = studyArea.hasPort();
                            break;
                        case Ui.INDOOR_FLAG:
                            isAvail = studyArea.isIndoor();
                            break;
                        case Ui.SIZE_FLAG:
                            isAvail = Integer.toString(studyArea.getMaxPax()).equals(flags[1]);
                            flags[1] = null; //so as to skip iteration on flags[1].
                            break;
                        default:
                            isAvail = containsKey(studyArea.getName(), studyArea.getFaculty(), flags[4]);
                            break;
                        }
                    }
                }
                if (isAvail) {
                    availStudyAreas.add(studyArea);
                }
            }
            return availStudyAreas;
        } catch (Exception e) {
            throw new IllegalStudyAreaException(e.getMessage());
        }
    }
}
