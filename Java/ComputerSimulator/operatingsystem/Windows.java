package Simulator.operatingsystem;

import lombok.Getter;

@Getter
public class Windows extends AbstractOperatingSystem{
    private final int windowsVersion = 10;

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.WINDOWS;
    }

}
