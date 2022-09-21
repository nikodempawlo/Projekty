package Simulator.operatingsystem;

public abstract class AbstractOperatingSystem implements OperatingSystem{
    @Override
    public void install() {
        System.out.println("Installing system");
    }

    @Override
    public void uninstall() {
        System.out.println("System uninstalled");
    }

    @Override
    public void update() {
        System.out.println("System updated");
    }
}
