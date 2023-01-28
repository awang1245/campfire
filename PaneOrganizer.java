package campfire;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaneOrganizer {

    private BorderPane root;
    private Pane gamePane;

    public PaneOrganizer() {
        this.root = new BorderPane();

        this.createGamePane();

    }

    public BorderPane getRoot() {
        return root;
    }

    private void createGamePane() {
        this.gamePane = new Pane();
        this.root.setCenter(this.gamePane);
    }

}
