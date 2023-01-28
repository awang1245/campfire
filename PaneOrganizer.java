package campfire;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaneOrganizer {

    private BorderPane root;
    private Pane gamePane;

    public PaneOrganizer() {
        this.createRootPane();
        this.createGamePane();
    }

    public BorderPane getRoot() {
        return this.root;
    }

    private void createRootPane() {
        this.root = new BorderPane();
        Image image = new Image(Constants.DANIEL_ART);
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(1009);
        iv1.setFitHeight(700);
        this.root.getChildren().add(iv1);
    }

    private void createGamePane() {
        this.gamePane = new Pane();
        this.root.setCenter(this.gamePane);
    }

}
