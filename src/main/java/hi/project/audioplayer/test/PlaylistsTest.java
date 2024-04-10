package hi.project.audioplayer.test;

import hi.project.audioplayer.vinnsla.Playlist;
import hi.project.audioplayer.vinnsla.Playlists;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class PlaylistsTest {

    private Playlists playlists;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        playlists = new Playlists();
    }

    @Test
    public void testGetIndex() {
        playlists.setIndex(5);
        assertEquals(5, playlists.getIndex());
    }
}
