package Simulator.operatingsystem;

public class Windows extends AbstractOperatingSystem{
    private final int windowsVersion = 10;

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.WINDOWS;
    }

    public int getWindowsVersion() {
        return windowsVersion;
    }
}
