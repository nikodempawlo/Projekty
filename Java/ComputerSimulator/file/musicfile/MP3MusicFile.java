package Simulator.file.musicfile;

import lombok.Getter;
@Getter
public class MP3MusicFile extends AbstractMusicFile{
    private final int quality;

    public MP3MusicFile(String name, String bandName, String title, int quality) {
        super(name, bandName, title);

        this.quality = quality;
    }

    @Override
    public void play() {
        System.out.println("Playing MP3 file");
    }

    @Override
    public String toString() {
        return "MP3MusicFile{" +
                "quality=" + quality +
                ", bandName='" + bandName + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
