package studyarea;

import org.junit.jupiter.api.Test;
import studyarea.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    Location location1 = new Location("mac commons", "utown", "nil", true, true, 5);

    LocationTest() throws Exception {
    }

    @Test
    void getName() {
        assertEquals("mac commons", location1.getName());
    }

    @Test
    void getAddress() {
        assertEquals("utown", location1.getAddress());
    }

    @Test
    void getFaculty() {
        assertEquals("nil", location1.getFaculty());
    }

    @Test
    void hasPort() {
        assertEquals(true, location1.hasPort());
    }

    @Test
    void isIndoor() {
        assertEquals(true, location1.isIndoor());
    }

    @Test
    void getMaxPax() {
        assertEquals(5, location1.getMaxPax());
    }
}