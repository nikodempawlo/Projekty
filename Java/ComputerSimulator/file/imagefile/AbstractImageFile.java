package Simulator.file.imagefile;

import Simulator.file.AbstractFile;
import Simulator.file.FileType;

public abstract class AbstractImageFile extends AbstractFile {

    protected AbstractImageFile(String name) {
        super(name);
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
