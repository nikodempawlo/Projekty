package Simulator.file.imagefile;

import lombok.Getter;

@Getter
public class JPGImageFile extends AbstractImageFile{
    private int compression;

    public JPGImageFile(String name, int compression) {
        super(name);

        this.compression = compression;
    }

    public void displayImage() {
        System.out.println("Displaying JPG");
    }
}
