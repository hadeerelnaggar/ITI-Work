module javafxModule {
    exports MovingCars;
    opens MovingCars to javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.materialdesign2;
}
