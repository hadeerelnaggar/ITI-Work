module javafxModule {
    exports program;
    opens program to javafx.fxml;
    opens program.controllers to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
}
