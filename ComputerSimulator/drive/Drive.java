package Simulator.drive;

import Simulator.file.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String name);
    void removeFile(String name);
}
