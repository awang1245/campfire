package campfire;

import javafx.scene.layout.BorderPane;

public class PaneOrganizer {

    private BorderPane root;

    public PaneOrganizer() {
        this.root = new BorderPane();
    }

    public BorderPane getRoot() {
        return root;
    }

}
