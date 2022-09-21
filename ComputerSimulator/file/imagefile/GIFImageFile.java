package Simulator.file.imagefile;

public class GIFImageFile extends AbstractImageFile{

    public GIFImageFile(String name) {
        super(name);
    }

    public void showAnimation() {
        System.out.println("Showing funny GIF");
    }

    public int getVersion() {
        return 2;
    }
}
