package hi.project.audioplayer.vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class AudioApplication extends Application {
    /**
     * A method to start the stage with a new scene and switch to the main view.
     *
     * @param  stage   the stage to start
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.MAIN, true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            launch();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
