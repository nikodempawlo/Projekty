package Simulator.operatingsystem;

import lombok.Getter;

@Getter
public class MacOS extends AbstractOperatingSystem{

    private final double version = 12.4;

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.MACOS;
    }
}
