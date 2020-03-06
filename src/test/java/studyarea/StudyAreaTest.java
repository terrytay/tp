package studyarea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudyAreaTest {
    StudyArea studyArea = new StudyArea();

    StudyAreaTest() throws Exception {
    }

    @Test
    void getLocationList() throws Exception {
        assertEquals(new Location("OCBC","2 College Ave West, Stephen Riady Centre",
                "-",true,false,2).getAddress(),
                studyArea.getLocationsList().get(1).getAddress());
    }
}