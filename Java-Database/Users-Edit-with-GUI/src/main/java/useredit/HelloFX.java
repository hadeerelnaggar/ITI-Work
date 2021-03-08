package useredit;

import javafx.application.Application;
import javafx.stage.Stage;
import useredit.utilities.StageCoordinator;
import useredit.server.daos.UserDao;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        StageCoordinator stageCoordinator = StageCoordinator.getInstance();
        stageCoordinator.setStage(stage);
        stageCoordinator.goToUserPage();
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        UserDao.getInstance().closeDao();
    }

    public static void main(String[] args) {
        launch();
    }

}