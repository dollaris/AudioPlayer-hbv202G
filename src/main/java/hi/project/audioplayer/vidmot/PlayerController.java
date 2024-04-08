package hi.project.audioplayer.vidmot;

import hi.project.audioplayer.vinnsla.Account;
import hi.project.audioplayer.vinnsla.Playlists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

public class PlayerController {
    @FXML
    private Label userName;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button fxPlaylist1;
    @FXML
    private Button fxPlaylist2;

    public void initialize() {
        ImageView img1 = new ImageView(new Image(getClass().getResourceAsStream("img/lake.jpeg")));
        ImageView img2 = new ImageView(new Image(getClass().getResourceAsStream("img/forest.jpeg")));
        img1.setFitHeight(200);
        img1.setFitWidth(200);
        img1.setPreserveRatio(true);
        img2.setFitWidth(200);
        img2.setFitHeight(200);
        img2.setPreserveRatio(true);
        fxPlaylist1.setGraphic(img1);
        fxPlaylist2.setGraphic(img2);
    }
    @FXML
    public void onLogin(ActionEvent e) {
        Dialog<Account> dialog = new AccountDialog(new Account(""));
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        Optional<Account> result = dialog.showAndWait();
        if(result.isPresent()) {
            Account player = result.get();
            userName.setText(player.getName());
        }
    }
    @FXML
    public void onChooseList(ActionEvent e) throws IOException {
        Button answer = (Button) e.getSource();
        int i = gridPane.getRowIndex(answer);
        int j = gridPane.getColumnIndex(answer);

        Playlists playlists = new Playlists();
        if (i == 0 && j == 0) {
            playlists.setPlaylistIndex(0);
        } else if (i == 0 && j == 1) {
            playlists.setPlaylistIndex(1);
        }
        ViewSwitcher.switchTo(View.PLAYLIST, false);
    }
}