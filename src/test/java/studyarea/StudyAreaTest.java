package studyarea;

import org.junit.jupiter.api.Test;
import ui.Ui;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.*;
import static ui.Constants.MAX_LINE_LENGTH;
import static ui.Constants.TAB;

//@@author terrytay
class StudyAreaTest {

    StudyArea location1 = new StudyArea("mac commons", "utown", "nil", true, true,
            5);

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

    @Test
    void getName() {
        assertEquals("mac commons", location1.getName());
    }


    //@@author NizarMohd
    @Test
    void testToString() {
       String out = "\t __________________________________________________________\n" +
               "\t Name: mac commons\n" +
               "\t Address: utown\n" +
               "\t Faculty: nil\n" +
               "\t Port: true\n" +
               "\t Indoor: true\n" +
               "\t Maximum number of Pax: 5\n" +
               "\t __________________________________________________________";
        assertEquals(out, location1.toString());
    }

    @Test
    void containsSearchKey_assertTrue() {
        assertTrue(location1.containsSearchKey("utown"));
    }

    @Test
    void containsSearchKey_assertFalse() {
        assertFalse(location1.containsSearchKey("u-town"));
    }


    @Test
    void isSizeCapable_assertTrue() {
        assertTrue(location1.isSizeCapable("3"));
    }

    @Test
    void isSizeCapable_assertFalse() {
        assertFalse(location1.isSizeCapable("10"));
    }
}