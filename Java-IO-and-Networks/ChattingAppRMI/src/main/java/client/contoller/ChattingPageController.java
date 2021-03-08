package client.contoller;

import client.HelloFX;
import client.model.UserInfo;
import client.utilities.ChatPageUtilities;
import client.utilities.MessageSender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import serverRemote.ChatServerInt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
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
    @FXML
    private Button sendImage;
    HelloFX helloFX;
    ObservableList<String> messages;
    ChatPageUtilities chatPageUtilities;

    public ChattingPageController(UserInfo user,HelloFX helloFX){
        System.out.println(user.getUserImage());
        messages= FXCollections.observableArrayList();
        this.user = user;
        this.helloFX=helloFX;
        chatPageUtilities = ChatPageUtilities.getInstance();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
                MessageSender messageSender = MessageSender.getInstance();
                messageSender.sendMessage(user,message.getText());
                message.setText("");
            }

        });
        sendImage.addEventHandler(ActionEvent.ACTION,(e)->{
            FileChooser fileChooser = new FileChooser();
            //fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("image files","*.png"));
            File userPhoto = fileChooser.showOpenDialog(sendImage.getScene().getWindow());
            int i = userPhoto.getName().lastIndexOf('.');
            String extension="";
            if (i > 0) {
                extension = userPhoto.getName().substring(i+1);
            }
            HelloFX helloFX = new HelloFX();
            ChatServerInt chatServerInt = helloFX.getChatServer();

            byte[] bytes = null;
            try {
                bytes = FileUtils.readFileToByteArray(userPhoto);
            } catch (IOException exp) {
                exp.printStackTrace();
            }
            MessageSender messageSender = MessageSender.getInstance();
            messageSender.sendImage(bytes,extension);

        });
    }
}
