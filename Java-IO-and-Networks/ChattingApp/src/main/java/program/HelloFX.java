package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controllers.LoginController;

import java.io.IOException;

public class HelloFX extends Application {

    Scene scene;
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;

        StageCoordinator stageCoordinator = StageCoordinator.getInstance();
        stageCoordinator.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        fxmlLoader.setController(new LoginController());
        Parent root = fxmlLoader.load();

        scene = new Scene(root);
        stage.setTitle("Chat App");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        ClientSocket clientSocket = ClientSocket.getInstance();
        clientSocket.sendMessage("End");
    }

    public static void main(String[] args) {
        launch();
    }

}