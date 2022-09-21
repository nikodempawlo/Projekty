package Simulator.peripherals;

public class Monitor {
    private int width = 1920;
    private int height = 1080;

    public static int MAX_HEIGHT = 3840;

    public static int getMaxHeight() {
        return MAX_HEIGHT;
    }

    public void setLowResolution() {
        width = 800;
        height = 600;
    }

    public void setHighResolution() {
        width = 3840;
        height = 2160;
    }

    public String getResolution() {
        return width + "x" + height;
    }
}
