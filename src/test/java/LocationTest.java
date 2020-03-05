import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    Location location1 = new Location("mac commons", "utown", "nil", true, true, 5);

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