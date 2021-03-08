package program;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    Button changePhoto;
    @FXML
    Button chat;
    @FXML
    TextField nameText;
    @FXML
    ImageView userImage;
    @FXML
    Label error;
    Image image;
    UserInfo user;
    HelloFX helloFX;

    LoginController(HelloFX helloFX){
        this.helloFX=helloFX;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changePhoto.setOnAction((e)->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("image files","*.jpg","*.png"));
            File userPhoto = fileChooser.showOpenDialog(changePhoto.getScene().getWindow());
            try {
                URL photoUrl = userPhoto.toURI().toURL();
                image = new Image(photoUrl.toExternalForm());
                userImage.setImage(image);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

        });
        chat.setOnAction((e)->{
            if(nameText.getText().equals("")){
                error.setText("please enter a name");
            }
            else{
                user=new UserInfo(nameText.getText(),image);
                helloFX.startChatPage(user);
            }
        });
    }
}
