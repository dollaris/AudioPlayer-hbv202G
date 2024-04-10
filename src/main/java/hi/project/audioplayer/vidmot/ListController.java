        package hi.project.audioplayer.vidmot;

        import hi.project.audioplayer.vinnsla.Playlist;
        import hi.project.audioplayer.vinnsla.Playlists;
        import hi.project.audioplayer.vinnsla.Song;
        import javafx.beans.value.ChangeListener;
        import javafx.beans.value.ObservableValue;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.ListView;
        import javafx.scene.control.ProgressBar;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.media.Media;
        import javafx.scene.media.MediaPlayer;
        import java.io.IOException;

        import static hi.project.audioplayer.vinnsla.Playlists.getPlaylist;

        public class ListController {
            @FXML
            private ListView<Song> fxListView;
            @FXML
            private ImageView fxImgSong;
            @FXML
            private ProgressBar fxProgressBar;
            private Playlist playlist;
            private Song currentSong;
            private Image img;
            private Media media;
            private MediaPlayer mediaPlayer;
            private boolean isPlayed = false;

            /**
             * Initialize method to set up the playlist, update the UI, and handle song selection.
             */
            public void initialize() {
                playlist = getPlaylist();
                if (playlist != null) {
                    fxListView.getItems().setAll(playlist.getSongs());
                    fxListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Song>() {
                        /**
                         * A description of the entire Java function.
                         *
                         * @param  observableValue	description of parameter
                         * @param  song	description of parameter
                         * @param  t1	description of parameter
                         * @return         	description of return value
                         */
                        @Override
                        public void changed(ObservableValue<? extends Song> observableValue, Song song, Song t1) {
                            if (t1 != null) {
                                currentSong = fxListView.getSelectionModel().getSelectedItem();
                                System.out.println("current song");
                                media = new Media(getClass().getResource(currentSong.getSongPathName()).toExternalForm());
                                mediaPlayer = new MediaPlayer(media);
                                System.out.println("current media");
                                Image img = new Image(getClass().getResource(currentSong.getImgName()).toExternalForm());
                                fxImgSong.setImage(img);

                            }
                        }
                    });
                } else {
                    System.err.println("Playlist is null in initialize method");
                }



            }

            @FXML
            public void onSelectSong(MouseEvent e) {
                selectSong();
                playSong();
            }

            @FXML
            private void selectSong() {
                media = new Media(currentSong.getSongPathName());
                mediaPlayer = new MediaPlayer(media);
                Image img = new Image(currentSong.getImgName());
                fxImgSong.setImage(img);
            }
            @FXML
            public void onHome() throws IOException {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                ViewSwitcher.switchTo(View.MAIN, true);
            }


            @FXML
            private void playSong() {
                if(!isPlayed) {
                    mediaPlayer.play();
                    setPlayer();
                    isPlayed = true;
                }

            }

            /**
             * Set the player, stop the media if already playing, update progress bar, and play next song.
             */
            @FXML
            private void setPlayer() {
                if (isPlayed) {
                    mediaPlayer.stop();
                }

                mediaPlayer.currentTimeProperty().addListener(((observable, old, newValue) ->
                        fxProgressBar.setProgress(newValue.divide(currentSong.getSongLength()).toMillis())));

                nextSong();
            }

            /**
             * Handles the play/pause action event.
             *
             * @param  e   The action event triggering the play/pause action
             * @return     None
             */
            @FXML
            public void onPlayPause(ActionEvent e) {
                if (isPlayed) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.play();
                }
                isPlayed = !isPlayed;
            }

            /**
             * Moves to the next song in the playlist. If there are no more songs,
             * it either handles the end of the playlist or loops back to the first song.
             *
             */
            private void nextSong() {
                Song nextSong = playlist.getNextSong();

                if (nextSong != null) {
                    currentSong = nextSong;
                    playSong();
                } else {
                    // Handle end of playlist or looping to the first song
                    // For example, go to the first song in the playlist:
                    fxListView.getSelectionModel().select(0);
                    selectSong();
                    playSong();
                    setPlayer();
                }

            }
        }
