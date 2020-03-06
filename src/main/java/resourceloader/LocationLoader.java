package resourceloader;

import java.io.File;
import java.io.FileNotFoundException;

public class LocationLoader implements Loader {
    private final String url;
    private File file;

    public LocationLoader(String url) {
        this.url = url;
    }

    public void loadFile() throws FileNotFoundException {
        try {
            file = new File(url);
        } catch (Exception e) {
            throw new FileNotFoundException("File not found.");
        }
    }

    public File getFile() {
        return this.file;
    }
}