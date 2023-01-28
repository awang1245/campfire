package campfire;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Cartoon {
    private Pane gamePane;
    private Timeline timeline;
    private Marshmallow marshmallow;
    public Cartoon(Pane gamePane){
        this.gamePane = gamePane;
        this.marshmallow = marshmallow;
        this.setUpTimeline();
    }

    private void setUpTimeline(){
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION),
                (ActionEvent e) -> this.updateTimeline());
        this.timeline = new Timeline();
        this.timeline.getKeyFrames().add(kf);
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    private void updateTimeline(){
        //if marshmallow side is certain distance from fire, change a shade darker

        this.gamePane.setOnKeyPressed((KeyEvent event) -> this.handleKeyPress(event));
        this.gamePane.setFocusTraversable(true);
    }

    private void handleKeyPress(KeyEvent e){

            switch(e.getCode()) {
                case LEFT:
                    this.marshmallow.move(1);
                    break;
                case RIGHT:
                    this.marshmallow.move(2);
                    break;
                case DOWN:
                    this.marshmallow.move(3);
                    break;
                case UP:
                    this.marshmallow.move(4);
                    break;
                case SPACE:
                    this.marshmallow.rotate();
                    break;
                default:
                    break;
            }


        e.consume();
    }
}
