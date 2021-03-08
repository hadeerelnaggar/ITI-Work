package program;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    @FXML
    private Label userName;
    @FXML
    private Label messageLabel;
    @FXML
    private ImageView userImage;
    UserInfo user;
    String message;
    MessageController(UserInfo user,String message){
        this.user=user;
        this.message=message;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(user.getUserName());
        if(user.getUserImage()!=null)
            userImage.setImage(user.getUserImage());
        messageLabel.setText(message);
    }
}
