package campfire;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Marshmallow {

    private Stripe[] stripes;
    private Pane gamePane;
    private Ellipse ellipse;

    public Marshmallow(Pane gamePane) {
        this.stripes = new Stripe[8];
        this.gamePane = gamePane;
        this.setupShape();
    }

    private void setupShape() {
        for (int i = 0; i < this.stripes.length; i++) {
            this.stripes[i] = new Stripe();
            this.stripes[i].setX(Constants.STARTING_XLOC);
            this.stripes[i].setY(i * Constants.STRIPE_HEIGHT + Constants.STARTING_YLOC);
            this.gamePane.getChildren().add(this.stripes[i].getRectangle());
        }
        this.ellipse = new Ellipse(Constants.ELLIPSE_WIDTH, Constants.STRIPE_HEIGHT * this.stripes.length / 2);
        this.ellipse.setCenterX(Constants.STARTING_XLOC);
        this.ellipse.setCenterY(Constants.STARTING_YLOC + Constants.STRIPE_HEIGHT * this.stripes.length / 2);
        //this.ellipse.setStroke(Color.BLUE);
        this.gamePane.getChildren().add(this.ellipse);
    }

    public void move(int direction) {
        //need to add checking for whether it's still on the screen
        switch (direction) {
            case 1:
                for (int i = 0; i < this.stripes.length; i++) {
                    this.stripes[i].setX(this.stripes[i].getX() - Constants.MOVEMENT_OFFSET);
                }
                this.ellipse.setCenterX(this.ellipse.getCenterX() - Constants.MOVEMENT_OFFSET);
                break;
            case 2:
                for (int i = 0; i < this.stripes.length; i++) {
                    this.stripes[i].setX(this.stripes[i].getX() + Constants.MOVEMENT_OFFSET);
                }
                this.ellipse.setCenterX(this.ellipse.getCenterX() + Constants.MOVEMENT_OFFSET);
                break;
            case 3:
                for (int i = 0; i < this.stripes.length; i++) {
                    this.stripes[i].setY(this.stripes[i].getY() + Constants.MOVEMENT_OFFSET);
                }
                this.ellipse.setCenterY(this.ellipse.getCenterY() + Constants.MOVEMENT_OFFSET);
                break;
            case 4:
                for (int i = 0; i < this.stripes.length; i++) {
                    this.stripes[i].setY(this.stripes[i].getY() - Constants.MOVEMENT_OFFSET);
                }
                this.ellipse.setCenterY(this.ellipse.getCenterY() - Constants.MOVEMENT_OFFSET);
                break;
            default:
                break;
        }
    }

    public void rotate() {

    }

    public void darken() {
        for (int i = 0; i < this.stripes.length; i++) {
            //if marshmallow stripe is certain distance from fire,
            this.stripes[i].darken();
        }

        //if ellipse is certain distance from fire,

    }

    public void setStripesColor(Color color) {
        for (int i = 0; i < this.stripes.length; i++) {
            //if marshmallow stripe is certain distance from fire,
            this.stripes[i].setColor(color);
        }
    }
}
