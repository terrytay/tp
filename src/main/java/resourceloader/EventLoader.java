package resourceloader;

import event.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EventLoader {

    private String filePath;
    private Path fileDirectory;

    public EventLoader(String filePath) {
        this.filePath = filePath;
        this.fileDirectory = Paths.get(filePath).getParent();
    }


    public ArrayList<Event> loadFile() {
        ArrayList<Event> events = new ArrayList<>();;
        File dataFile;
        Scanner s;
        try {
            dataFile = new File(filePath);
            s = new Scanner(dataFile);
            while (s.hasNext()) {
                String eventDescription = s.nextLine();
                Event newEvent = parseEventDetails(eventDescription);
                events.add(newEvent);
            }
        }  catch (FileNotFoundException e) {
            createNewDataFile();
        }
        return events;
    }

    private Event parseEventDetails(String taskDescription) {
        String[] splitDescription = taskDescription.split("#", 5);
        String description = splitDescription[0];
        String date = splitDescription[1];
        String startTime = splitDescription[2];
        String endTime = splitDescription[3];
        String priority = splitDescription[4];
        return new Event(description ,date ,startTime, endTime, priority);
    }

    private void createNewDataFile() {

        try {
            Files.createDirectories(fileDirectory);
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEvents(ArrayList<Event> events) {

        try {
            FileWriter fw = new FileWriter(filePath);
            for (Event event: events) {
                fw.write(event.getFormattedDetails());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
