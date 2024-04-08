package hi.project.audioplayer.vinnsla;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Account {
    private final StringProperty name = new SimpleStringProperty();

    public Account(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }


    public StringProperty nameProperty() {
        return this.name;
    }
}

