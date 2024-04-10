module hi.project.vidmot.audioplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires junit;


    opens hi.project.audioplayer.vidmot to javafx.fxml, javafx.media;
    exports hi.project.audioplayer.vidmot;
    exports hi.project.audioplayer.vinnsla;
    exports hi.project.audioplayer.test;
}