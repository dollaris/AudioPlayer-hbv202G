package hi.project.audioplayer.vinnsla;

public class Song {
    private String songPathName;
    private String songName;
    private String imgName;
    private Double songLength;

    /**
     *
     * @param songPathName
     * @param songName
     * @param songLength
     * @param imgName
     */
    public Song(String songPathName, String songName, Double songLength, String imgName) {
        this.songPathName = songPathName;
        this.songName = songName;
        this.imgName= imgName;
        this.songLength = songLength;
    }

    /**
     * Retrieves the song path name.
     *
     * @return the path of the song
     */
    public String getSongPathName() {
        return songPathName;
    }

    /**
     * Sets the song path name.
     *
     * @param  songPathName  the new path name for the song
     */
    public void setSongPathName(String songPathName) {
        this.songPathName = songPathName;
    }

    /**
     * Get the name of the song.
     *
     * @return         the name of the song
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Get the name of the song.
     *
     * @return         the name of the song
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * Get the name of the image.
     *
     * @return         the name of the image
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * Set the image name.
     *
     * @param  imgName  the new image name
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * Get the length of the song.
     *
     * @return         the length of the song
     */
    public Double getSongLength() {
        return songLength;
    }

    /**
     * Set the length of the song.
     *
     * @param  songLength  the new length of the song
     */
    public void setSongLength(Double songLength) {
        this.songLength = songLength;
    }

    /**
     * A description of the entire Java function.
     *
     * @return         	description of return value
     */
    @Override
    public String toString() {
        return songName;
    }
}
