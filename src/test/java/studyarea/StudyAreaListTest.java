package studyarea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StudyAreaListTest {

    //  An exception pertaining to duplicate flag should be raised if the location at flag[index] is not null.
    @Test
    void checkDuplicate_gotDuplicate_raiseException() {
        String[] flag = {"-a", "-b"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkDuplicate(flag, 0));
    }

    // An exception pertaining to flag missing hyphen should be raised when flag has no hyphen.
    @Test
    void checkOnlyFlag_withoutHyphenSign_raiseException() {
        String[] commands = {"f"};
        Assertions.assertThrows(IllegalStudyAreaException.class, () -> StudyAreaList.checkOnlyFlag(commands, 0));

    }

    @Test
    void checkFlag() {
    }

    @Test
    void getFlagsInfo() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void searchList() {
    }
}