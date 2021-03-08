package client;

import client.contoller.ChattingPageController;
import client.contoller.LoginController;
import client.contoller.MessageController;
import client.model.UserInfo;
import client.utilities.MessageSender;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import serverRemote.ChatServerInt;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloFX extends Application {

    Scene scene;
    Stage stage;
    ChatClientImpl chatClient;
    ChatServerInt chatServer;
    @Override
    public void start(Stage stage) throws IOException {

        chatClient = new ChatClientImpl();
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",8189);
            chatServer = (ChatServerInt) reg.lookup("ChatService");
            MessageSender messageSender = MessageSender.getInstance();
            messageSender.setChatServer(chatServer);
            chatServer.register(chatClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
        fxmlLoader.setController(new LoginController(this));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        stage.setTitle("Chat App");
        stage.setScene(scene);
        stage.show();
    }

    public ChatServerInt getChatServer(){
        return chatServer;
    }
    @Override
    public void stop() throws Exception {
        chatServer.unregister(chatClient);
        UnicastRemoteObject.unexportObject(chatClient,true);
    }

    public void startChatPage(UserInfo user){
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

    public static void main(String[] args) {
        launch();
    }

}