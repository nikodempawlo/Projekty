package Simulator.operatingsystem;

public interface OperatingSystem {
    void install();
    void uninstall();
    void update();
    OperatingSystemType getType();
}
