module javafxModule {
    exports DirectoryStructure;
    opens DirectoryStructure to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.materialdesign2;
}
