package resourceloader;

import org.junit.jupiter.api.Test;
import studyarea.StudyArea;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudyAreaLoaderTest {

    StudyAreaLoader locationLoader = new StudyAreaLoader("library/locations.txt");

    StudyAreaLoaderTest() throws FileNotFoundException {
    }

    @Test
    void getFile() throws FileNotFoundException {
        locationLoader.loadFile();
        assertEquals(new File("library/locations.txt"), locationLoader.getFile());
    }
}