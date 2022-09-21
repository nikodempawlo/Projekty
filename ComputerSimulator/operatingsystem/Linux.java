package Simulator.operatingsystem;

public class Linux extends AbstractOperatingSystem{

    private final String version = "Ubuntu studio";

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.LINUX;
    }

    public String getVersion() {
        return version;
    }
}
