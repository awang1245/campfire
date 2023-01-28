package campfire;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Cartoon {
    private Pane gamePane;
    private Timeline timeline;
    private Marshmallow marshmallow;
    private int colorCounter;

    public Cartoon(Pane gamePane) {
        this.gamePane = gamePane;
        this.marshmallow = new Marshmallow(this.gamePane);
        this.setUpTimeline();
        this.colorCounter = 0;
    }

    private void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION),
                (ActionEvent e) -> this.updateTimeline());
        this.timeline = new Timeline();
        this.timeline.getKeyFrames().add(kf);
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    private void updateTimeline() {
        this.colorCounter++;
        if (this.colorCounter == 8) {
            this.marshmallow.setStripesColor(Color.BURLYWOOD);
        } else if (this.colorCounter == 16) {
            this.marshmallow.setStripesColor(Color.PERU);
        } else if (this.colorCounter == 24) {
            this.marshmallow.setStripesColor(Color.SIENNA);
        }
        this.marshmallow.darken();
        this.gamePane.setOnKeyPressed((KeyEvent event) -> this.handleKeyPress(event));
        this.gamePane.setFocusTraversable(true);
    }

    private void handleKeyPress(KeyEvent e) {

        switch (e.getCode()) {
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
