module javafxModule {
    exports client;
    exports clientRemote;
    exports serverRemote;
    exports server;
    opens client.contoller to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.rmi;
    requires java.desktop;
    requires org.apache.commons.io;

}
