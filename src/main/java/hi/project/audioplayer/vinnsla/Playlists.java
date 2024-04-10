package hi.project.audioplayer.vinnsla;

import java.io.IOException;
import java.net.URISyntaxException;

public class Playlists {
    private static int index;
    private static final int NUMBER_OF_PLAYLISTS = 2;
    private static Playlist[] playlists = new Playlist[NUMBER_OF_PLAYLISTS];
    private static final String[] fileNames = new String[]{"playlist-one.txt", "playlist-two.txt"};

    /**
     *  Constructor
     */
    public Playlists() {
        initializePlaylists();
    }

    /**
     * Initialize the playlists
     */
    public static void initializePlaylists() {
        // Initialize the playlists
        for (int i = 0; i < playlists.length; i++) {
            try {
                playlists[i] = new Playlist(fileNames[i]);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Get the current playlist
     */
    public static Playlist getPlaylist() {
        return playlists[index];
    }

    /**
     * Sets the playlist index if it's within the valid range.
     *
     * @param  index   the index to set
     * @return          no return value
     */
    public void setPlaylistIndex(int index) {
        if (index >= 0 && index < NUMBER_OF_PLAYLISTS) {
            this.index = index;
        } else {
            // Handle invalid index (print a message, throw an exception, or take corrective action)
            System.err.println("Invalid playlist index: " + index);
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }
}
