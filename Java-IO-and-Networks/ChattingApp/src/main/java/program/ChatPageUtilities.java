package program;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import program.controllers.ChattingPageController;
import program.controllers.MessageController;

import java.io.IOException;

public class ChatPageUtilities {
    VBox vBox;
    private static ChatPageUtilities chatPageUtilities;
    private ChatPageUtilities(){

    }
    public synchronized static ChatPageUtilities getInstance(){
        if(chatPageUtilities==null){
            chatPageUtilities = new ChatPageUtilities();
        }
        return chatPageUtilities;
    }
    public void setVBox(VBox vBox){
        this.vBox = vBox;
    }
    public void addMessage(UserInfo user, String message){
        MessageController messageController = new MessageController(user,message);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/message.fxml"));
        fxmlLoader.setController(messageController);
        try {
            vBox.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
