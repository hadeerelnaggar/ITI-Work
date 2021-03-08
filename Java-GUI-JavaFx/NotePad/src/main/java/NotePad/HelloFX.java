package NotePad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new NotePad(stage), 640, 480);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("NotePad");
    }

    public static void main(String[] args) {
        launch();
    }

}