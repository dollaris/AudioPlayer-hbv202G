package hi.project.audioplayer.vinnsla;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
    private final StringProperty name = new SimpleStringProperty();

    /**
     * Get the name.
     *
     * @return         	the name
     */
    public Account(String name) {
        this.name.set(name);
    }

    /**
     * Retrieves the name.
     *
     * @return         	the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Get the name.
     *
     * @return         	the name
     */
    public StringProperty nameProperty() {
        return this.name;
    }
}

