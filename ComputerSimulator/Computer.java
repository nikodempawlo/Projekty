package Simulator;

import Simulator.drive.Drive;
import Simulator.operatingsystem.OperatingSystem;
import Simulator.peripherals.Headphones;
import Simulator.peripherals.Keyboard;
import Simulator.peripherals.Monitor;
import Simulator.usbdevice.USBDevice;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Monitor monitor;
    private Drive drive;
    private Drive extraDrive;
    private Headphones headphones;
    private Keyboard keyboard;
    private OperatingSystem operatingSystem;

    private List<USBDevice> usbDevices = new ArrayList<>();

    public Computer(Monitor monitor, Drive drive, OperatingSystem operatingSystem) {
        this.monitor = monitor;
        this.drive = drive;
        this.operatingSystem = operatingSystem;
    }

    public Computer(Monitor monitor, Drive drive, Drive extraDrive, OperatingSystem operatingSystem){
        this.monitor = monitor;
        this.drive = drive;
        this.extraDrive = extraDrive;
        this.operatingSystem = operatingSystem;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Headphones getHeadphones() {
        return headphones;
    }

    public Keyboard getKeyboard() { return keyboard; }

    public void setHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    public List<USBDevice> getUsbDevices() {
        return usbDevices;
    }

    public void addUSBDevice(USBDevice usbDevice) {
        boolean isConnected = usbDevice.connect();

        if (isConnected) {
            usbDevices.add(usbDevice);
        }
    }

    public void removeUSBDevice(USBDevice usbDevice) {
        boolean isDisconnected = usbDevice.disconnect();

        if (isDisconnected) {
            usbDevices.remove(usbDevice);
        }
    }

}
