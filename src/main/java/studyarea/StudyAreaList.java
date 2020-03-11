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
     * This method checks for duplicate flags.
     * @param flag this is the array of flags in the system.
     * @param index this is the index referring to the specific flag to check for duplicate.
     * @throws IllegalStudyAreaException if flag is not null, ie: if flag has already been mentioned.
     */
    public void checkDuplicate(String[] flag, int index) throws IllegalStudyAreaException {
        if (flag[index] != null) {
            throw new IllegalStudyAreaException(Ui.DUPLICATE_FLAGS);
        }
    }

    /**
     * This method check if command entered is only flags.
     * @param commands This is the string of commands entered by User.
     * @param index This is the index in which the method is check if only flag exist.
     * @throws IllegalStudyAreaException if only flag is entered by user.
     */

    public void checkOnlyFlag(String[] commands, int index) throws IllegalStudyAreaException {
        if (commands[index].length() == 1) {
            throw new IllegalStudyAreaException(Ui.ONLY_FLAG);
        }
    }

    /**
     * This method assigns flags based on User input.
     *
     * @param flags this is the array of flags.
     * @param commands this is the full command entered by Users.
     * @param index this is the index which the method is assigning the commands into the flags array.
     * @param isNotFlag this is the boolean value that checks if the command entered is a flag.
     * @throws IllegalStudyAreaException if user enters command wrongly.
     */
    public void checkFlag(String[] flags, String[] commands, int index, boolean isNotFlag) throws
            IllegalStudyAreaException {

        if (commands[index].equals(Ui.SIZE_FLAG)) {
            checkDuplicate(flags, 0);
            try {
                int size = Integer.parseInt(commands[index + 1]);
            } catch (NumberFormatException e) {
                throw new IllegalStudyAreaException(Ui.NOT_INTEGER);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalStudyAreaException(Ui.NO_SIZE_INDICATED);
            }
        } else if (commands[index].contains(Ui.FLAG)) {
            checkOnlyFlag(commands, index);
            switch (commands[index].charAt(1)) {
            case 'p':
                checkDuplicate(flags, 2);
                break;
            case 'i':
            case 'o':
                checkDuplicate(flags, 3);
                break;
            default:
                throw new IllegalStudyAreaException(Ui.WRONG_FLAG_USAGE);
            }
        } else {
            if (!isNotFlag) {
                throw new IllegalStudyAreaException(Ui.WRONG_FLAG_ARGUMENT_POSITION);
            }
        }
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
                isNotFlag = false;                              // update isNotFlag as false because command is a flag
                checkFlag(flags, commands, i, false); // pass false instead of isNotFlag as only boolean logic
                flags[0] = Ui.SIZE_FLAG;
                flags[1] = Integer.toString(Integer.parseInt(commands[i + 1]));
                i++;
            } else if (commands[i].contains(Ui.FLAG)) {
                isNotFlag = false;
                checkFlag(flags, commands, i,false);
                switch (commands[i].charAt(1)) {
                case 'p':
                    flags[2] = Ui.PORTS_FLAG;
                    break;
                case 'i':
                    flags[3] = Ui.INDOOR_FLAG;
                    break;
                case 'o':
                    flags[3] = Ui.OUTDOOR_FLAG;
                    break;
                default:
                    throw new IllegalStudyAreaException(Ui.WRONG_FLAG_USAGE);
                }
            } else {
                if (isNotFlag) {
                    checkFlag(flags, commands, i, true);
                    name.append(commands[i]).append(Ui.SPACE);
                    flags[4] = name.toString().trim();
                } else {
                    checkFlag(flags, commands, i, false);
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
     * @throws IllegalStudyAreaException if User enters invalid commands.
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
                        case Ui.OUTDOOR_FLAG:
                            isAvail = !studyArea.isIndoor();
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