package command.studyarea;

import org.junit.jupiter.api.Test;
import studyarea.StudyArea;
import studyarea.StudyAreaList;
import ui.Ui;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static ui.Constants.*;

//@@author NizarMohd

class StudyAreaCommandTest {


    @Test
    void validateCommand_throwsException_blankCommand() {
        try {
                String command = "";
                command = StudyAreaCommand.validateCommand(command);
                fail("should have raised an exception");
        } catch (Exception e) {
            assertEquals(EMPTY_LOCATION, e.getMessage());
        }

    }

    @Test
    void validateCommand_throwsException_shortCommand() {
        try {
            String command = "a";
            command = StudyAreaCommand.validateCommand(command);
            fail("should have raised an exception");
        } catch (Exception e) {
            assertEquals(SHORT_DESCRIPTION, e.getMessage());
        }
    }

    @Test
    void filterCommand_throwsException_wrongCommand() {

        try {
            String command = "-z";
            boolean b = StudyAreaCommand.filterCommand(command, new StudyAreaList(new ArrayList<>()), new Ui());
        } catch (Exception e) {
            assertEquals(WRONG_FLAG_USAGE, e.getMessage());
        }
    }

}