module javafxModule {
    exports useredit;
    opens useredit.controllers to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.materialdesign2;
    requires mysql.connector.java;
    requires java.sql;
    requires java.naming;
    requires java.rmi;
    exports useredit.server.daos;

}
