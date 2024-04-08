    package hi.project.audioplayer.vinnsla;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.scene.image.Image;
    import javafx.scene.media.Media;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.net.URISyntaxException;
    import java.nio.charset.StandardCharsets;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Scanner;

    public class Playlist {
        private ObservableList<Song> list;
        private int index = 0;
        private String playlistFile;
        private Song song;

        public Playlist(String playlist) throws IOException, URISyntaxException {
            this.playlistFile = playlist;
            readSong();
        }

        public void readSong() throws IOException, URISyntaxException {
            list = FXCollections.observableArrayList();
            Path paths = Paths.get(playlistFile);
            BufferedReader bufferedReader = Files.newBufferedReader(paths, StandardCharsets.UTF_8);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length >= 4) {
                    String path = parts[0].trim();
                    String name = parts[1].trim();
                    double length = Double.parseDouble(parts[2].trim());
                    String imgPath = parts[3].trim();

                    Song song = new Song(path, name, length, imgPath);
                    list.add(song);
                } else {
                    // Handle incomplete or improperly formatted lines
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        }
        public Song getCurrentSong() {
            if (index >= 0 && index < list.size()) {
                return list.get(index);
            }
            return null;
        }

        public Song getNextSong() {
            index++;
            if (index >= list.size()) {
                // Reached the end of the playlist
                // You can choose to loop back to the first song or return null to stop playback
                index = 0; // Loop back to the first song
                // return null; // Stop playback
            }
            return getCurrentSong();
        }

        public ObservableList<Song> getSongs() {
            return list;
        }
    }
