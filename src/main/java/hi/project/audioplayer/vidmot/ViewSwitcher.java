package hi.project.audioplayer.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewSwitcher {
    private static Map<View, Parent> cache = new HashMap<>();
    private static Scene scene;

    /**
     * Sets the scene for the ViewSwitcher.
     *
     * @param  scene  the scene to be set
     * @return       void
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * A method to switch the view and handle caching.
     *
     * @param  view    the view to switch to
     * @param  isCache flag indicating whether to cache the view
     * @throws IOException if an I/O error occurs during the view switching process
     */
    public static void switchTo(View view, boolean isCache) throws IOException {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            if (cache.containsKey(view)) {
                System.out.println("Loading from cache");
                root = cache.get(view);
            } else {
                System.out.println("Loading from FXML");
                root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
                if(isCache) {
                    cache.put(view, root);
                }
            }

            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
