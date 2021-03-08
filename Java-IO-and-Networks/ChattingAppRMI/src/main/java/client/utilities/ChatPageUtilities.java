package client.utilities;

import client.contoller.MessageController;
import client.model.UserInfo;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChatPageUtilities {
    VBox vBox;
    private static ChatPageUtilities chatPageUtilities;

    private ChatPageUtilities() {

    }

    public synchronized static ChatPageUtilities getInstance() {
        if (chatPageUtilities == null) {
            chatPageUtilities = new ChatPageUtilities();
        }
        return chatPageUtilities;
    }

    public void setVBox(VBox vBox) {
        this.vBox = vBox;
    }

    public void addMessage(UserInfo user, String message) {
        MessageController messageController = new MessageController(user, message);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/message.fxml"));
        fxmlLoader.setController(messageController);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    vBox.getChildren().add(fxmlLoader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
