package Simulator.file.textfile;

import Simulator.file.AbstractFile;
import Simulator.file.File;
import Simulator.file.FileType;

public class TextFile extends AbstractFile {

    public TextFile(String name) {
        super(name);
    }

    public void editFile(File file){
        System.out.println("Editing file");
    }

    @Override
    public FileType getType() {
        return FileType.TEXT;
    }
}
