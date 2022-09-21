package Simulator.file.imagefile;

public class JPGImageFile extends AbstractImageFile{
    private int compression;

    public JPGImageFile(String name, int compression) {
        super(name);

        this.compression = compression;
    }

    public int getCompression() {
        return compression;
    }

    public void displayImage() {
        System.out.println("Displaying JPG");
    }
}
