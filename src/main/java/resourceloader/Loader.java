package resourceloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Loader is a resource loader for all the external data that is within our java program.
 * Examples of resources will be task data, study locations etc..
 * Loader is an interface that enables subsequent loaders to be made and disciplined,
 * i.e. locationsLoader, organiserLoader..
 */
public interface Loader {
    public void loadFile() throws FileNotFoundException;

    public File getFile();
}
