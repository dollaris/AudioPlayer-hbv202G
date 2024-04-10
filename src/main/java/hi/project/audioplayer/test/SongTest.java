package hi.project.audioplayer.test;

import hi.project.audioplayer.vinnsla.Song;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class SongTest {

    private Song song;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        song = new Song("testPath", "testName", 100.0, "testImgName");
    }

    @Test
    public void testGetters() {
        assert song.getSongPathName().equals("testPath");
        assert song.getSongName().equals("testName");
        assert song.getSongLength() == 100.0;
        assert song.getImgName().equals("testImgName");
    }

    @Test
    public void testSetters() {
        song.setSongPathName("testPath2");
        song.setSongName("testName2");
        song.setSongLength(200.0);
        song.setImgName("testImgName2");
        assert song.getSongPathName().equals("testPath2");
        assert song.getSongName().equals("testName2");
        assert song.getSongLength() == 200.0;
        assert song.getImgName().equals("testImgName2");
    }







}
