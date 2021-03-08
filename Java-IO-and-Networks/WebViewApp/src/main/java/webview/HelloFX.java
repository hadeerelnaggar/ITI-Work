package webview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException, IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("/page.fxml"));
        StackPane stackPane = new StackPane(root);
        Scene scene = new Scene(stackPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}