package useredit.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageCoordinator {
    private Stage stage;
    private static StageCoordinator stageCoordinator;
    private StageCoordinator(){

    }
    public synchronized static StageCoordinator getInstance(){
        if(stageCoordinator ==null){
            stageCoordinator =new StageCoordinator();
        }
        return stageCoordinator;
    }
    public void setStage(Stage stage){
        if(this.stage!=null)
            throw new RuntimeException("stage is already defined ");
        this.stage=stage;
    }
    public void goToUserPage(){
        try {
            Parent root =FXMLLoader.load(getClass().getResource("/Views/UserPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
