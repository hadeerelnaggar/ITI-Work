package program;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloFX extends Application {

    Scene scene;
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        fxmlLoader.setController(new LoginController(this));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage.setTitle("Chat App");
        stage.setScene(scene);
        stage.show();
    }

    public void startChatPage(UserInfo user){
        //System.out.println(user.getUserImage());
        ChattingPageController chattingPageController = new ChattingPageController(user,this);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chattingPage.fxml"));
        fxmlLoader.setController(chattingPageController);
        Parent root;
        stage.setHeight(500);
        try {
             root = fxmlLoader.load();
             scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Parent addMessage(UserInfo user,String message){
        MessageController messageController = new MessageController(user,message);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/message.fxml"));
        fxmlLoader.setController(messageController);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch();
    }

}