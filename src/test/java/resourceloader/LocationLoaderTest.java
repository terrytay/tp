package resourceloader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationLoaderTest {
    LocationLoader locationLoader = new LocationLoader("library/locations.txt");

    @Test
    void loadFile() throws FileNotFoundException {
        locationLoader.loadFile();
        assertEquals(new File("library/locations.txt"), locationLoader.getFile());
    }
}