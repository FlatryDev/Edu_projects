package SearchFiles;

import java.io.File;
import java.util.List;

public class ListFiles {
    private final File path;

    public ListFiles(File path) {
        this.path = path;
    }

    public File[] getPaths() {
        return path.listFiles(File::isDirectory);
    }

    public File[] getFilesByParams(Long length) {
        return path.listFiles(file -> file.isFile() && file.length() > length);
    }
}
