package Simulator.operatingsystem;

public class MacOS extends AbstractOperatingSystem{

    private final double version = 12.4;

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.MACOS;
    }

    public double getVersion() {
        return version;
    }
}
