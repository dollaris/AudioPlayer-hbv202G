package hi.project.audioplayer.vidmot;

public enum View {
    MAIN("home-view.fxml"),
    PLAYLIST("list-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
