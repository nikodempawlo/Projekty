package Simulator.file;

public abstract class AbstractFile implements File{
    protected String name;

    protected AbstractFile(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
