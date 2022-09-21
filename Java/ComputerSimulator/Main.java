package Simulator;

import Simulator.drive.HDDDrive;
import Simulator.drive.SSDDrive;
import Simulator.file.imagefile.GIFImageFile;
import Simulator.file.imagefile.JPGImageFile;
import Simulator.file.musicfile.MP3MusicFile;
import Simulator.file.textfile.TextFile;
import Simulator.operatingsystem.Windows;
import Simulator.peripherals.Monitor;
import Simulator.usbdevice.MemoryStick;
import Simulator.usbdevice.Mouse;

public class Main {

    public static void main(String[] args) {

        // example usage

        Monitor monitor = new Monitor();
        HDDDrive hddDrive = new HDDDrive();
        SSDDrive ssdDrive = new SSDDrive();
        Windows windows = new Windows();

        Computer computer = new Computer(monitor, hddDrive, ssdDrive, windows);

        Mouse mouse = new Mouse("mouse");
        mouse.connect();

        windows.install();
        windows.update();

        monitor.setHighResolution();
        monitor.getResolution();

        GIFImageFile gif_file = new GIFImageFile("gifFile1.gif");
        JPGImageFile jpgImageFile = new JPGImageFile("file1.jpg", 100);
        JPGImageFile jpgImageFile2 = new JPGImageFile("file2.jpg",100);
        MP3MusicFile mp3MusicFile = new MP3MusicFile("musicFile1.mp3", "Metallica", "Sad but true", 80);
        TextFile textFile = new TextFile("file.txt");
        TextFile textFile2 = new TextFile("file2.txt");
        TextFile textFile3 = new TextFile("file3.txt");

        hddDrive.addFile(gif_file);
        hddDrive.addFile(jpgImageFile);
        hddDrive.addFile(mp3MusicFile);

        ssdDrive.addFile(jpgImageFile2);
        ssdDrive.addFile(textFile);
        ssdDrive.addFile(textFile2);
        ssdDrive.addFile(textFile3);

        hddDrive.listFiles();
        ssdDrive.listFiles();

        System.out.println("Founded file: " + hddDrive.findFile("musicFile1.mp3"));
        System.out.println("Founded file: " + ssdDrive.findFile("file2.jpg"));

        hddDrive.removeFile("file1.jpg");
        hddDrive.listFiles();

        MemoryStick pendrive = new MemoryStick("Pendrive");

        computer.addUSBDevice(pendrive);

        pendrive.eject();

    }
}
