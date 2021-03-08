package program.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import program.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChattingPageController implements Initializable {
    UserInfo user;
    @FXML
    private VBox vBox;
    @FXML
    private Button send;
    @FXML
    private TextField message;
    @FXML
    private Label usernameText;
    @FXML
    private ImageView userImage;
    @FXML
    private ScrollPane scrollPane;
    ObservableList<String> messages;
    ChatPageUtilities chatPageUtilities;

    public ChattingPageController(UserInfo user){
        System.out.println(user.getUserImage());
        messages= FXCollections.observableArrayList();
        this.user = user;
        chatPageUtilities = ChatPageUtilities.getInstance();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ClientSocket.getInstance();
        chatPageUtilities.setVBox(vBox);
        System.out.println(user.getUserName());
        usernameText.setText(user.getUserName());
        usernameText.setWrapText(true);
        if(user.getUserImage()!=null)
            userImage.setImage(user.getUserImage());
        send.setOnAction((e)->{
            if(!message.getText().equals("")){
                messages.add(message.getText());
                scrollPane.setStyle("-fx-background: #424242");
                scrollPane.setFitToWidth(true);
                scrollPane.setFitToHeight(true);
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                scrollPane.setPannable(true);
                scrollPane.setFitToHeight(true);
                scrollPane.vvalueProperty().bind(vBox.heightProperty());
                vBox.setAlignment(Pos.TOP_RIGHT);
                MessageHandler messageHandler = new MessageHandler(message.getText());
                messageHandler.start();
                chatPageUtilities.addMessage(user,message.getText());
                message.setText("");
            }
        });
    }
}
