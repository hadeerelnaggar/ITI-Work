package MovingCars;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.media.AudioClip;

public class MovingCarController implements Initializable {
    @FXML
    ImageView carPhoto;
    @FXML
    Path path;
    @FXML
    ImageView car2Photo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/sounds/car-honk-1.wav");
        AudioClip audioClip = new AudioClip(file.toURI().toString());
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(carPhoto);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        PathTransition pathTransition2 = new PathTransition();
        pathTransition2.setDuration(Duration.millis(3000));
        pathTransition2.setPath(path);
        pathTransition2.setNode(car2Photo);
        pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition2.setCycleCount(Timeline.INDEFINITE);
        pathTransition.play();
        pathTransition2.play();

        carPhoto.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
            if(e.getClickCount()==2)
                reversePath(pathTransition);
            if(e.getClickCount()==1){
                audioClip.play(1);
            }
        });
        car2Photo.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
            if(e.getClickCount()>=2){
                System.out.println("kkk");
                reversePath(pathTransition2);
            }
            if(e.getClickCount()==1){
                audioClip.play(1);
            }
        });
    }
    private void reversePath(PathTransition pathTransition){
       pathTransition.setRate(-1);
    }
}
