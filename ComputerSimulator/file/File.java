package Simulator.file;

public interface File {
    String getName();
    FileType getType();
    default int getVersion() {
        return 1;
    }
}
