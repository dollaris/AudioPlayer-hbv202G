package hi.project.audioplayer.vinnsla;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.nio.file.Path;

public class Song {
    private String songPathName;
    private String songName;
    private String imgName;
    private Double songLength;

    public Song(String songPathName, String songName, Double songLength, String imgName) {
        this.songPathName = songPathName;
        this.songName = songName;
        this.imgName= imgName;
        this.songLength = songLength;
    }

    public String getSongPathName() {
        return songPathName;
    }

    public void setSongPathName(String songPathName) {
        this.songPathName = songPathName;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Double getSongLength() {
        return songLength;
    }

    public void setSongLength(Double songLength) {
        this.songLength = songLength;
    }

    @Override
    public String toString() {
        return songName;
    }
}
