package studyarea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudyAreaListTest {
    StudyAreaList studyAreaList = new StudyAreaList();

    StudyAreaListTest() throws Exception {
    }

    @Test
    void getStudyAreaList() throws Exception {
        assertEquals(new StudyArea("OCBC","2 College Ave West, Stephen Riady Centre",
                "-",true,false,2).getAddress(),
                studyAreaList.getStudyAreaList().get(1).getAddress());
    }
}