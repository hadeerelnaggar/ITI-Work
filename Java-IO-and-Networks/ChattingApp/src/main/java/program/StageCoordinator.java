package program;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controllers.ChattingPageController;
import program.controllers.MessageController;

import java.io.IOException;

public class StageCoordinator {
    private static StageCoordinator stageCoordinator;
    Stage stage;
    private StageCoordinator(){

    }
    public synchronized static StageCoordinator getInstance(){
        if(stageCoordinator==null){
            stageCoordinator=new StageCoordinator();
        }
        return stageCoordinator;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }

    public void startChatPage(UserInfo user){
        //System.out.println(user.getUserImage());
        ChattingPageController chattingPageController = new ChattingPageController(user);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chattingPage.fxml"));
        fxmlLoader.setController(chattingPageController);
        Parent root;
        stage.setHeight(500);
        try {
            root = fxmlLoader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
