package Simulator.operatingsystem;

import lombok.Getter;

@Getter
public class Linux extends AbstractOperatingSystem{

    private final String version = "Ubuntu studio";

    @Override
    public OperatingSystemType getType() {
        return OperatingSystemType.LINUX;
    }
}
