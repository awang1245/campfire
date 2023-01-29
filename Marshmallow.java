package campfire;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Marshmallow {

    private Stripe[] stripes;
    private Pane gamePane;
    private Ellipse ellipse;
    private Rectangle rectangle;

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
        //for the stick
        this.rectangle = new Rectangle(Constants.X_LIMIT, 10, Color.SADDLEBROWN);
        this.rectangle.setX(Constants.STARTING_XLOC + Constants.STRIPE_WIDTH);
        this.rectangle.setY(Constants.STARTING_YLOC + Constants.STRIPE_HEIGHT * this.stripes.length / 2 - 5);
        this.gamePane.getChildren().add(this.rectangle);
    }

    public void move(int direction) {
        //need to add checking for whether it's still on the screen
        switch (direction) {
            case 1:
                if (this.ellipse.getCenterX() > Constants.X_LIMIT) {
                    for (int i = 0; i < this.stripes.length; i++) {
                        this.stripes[i].setX(this.stripes[i].getX() - Constants.MOVEMENT_OFFSET);
                    }
                    this.ellipse.setCenterX(this.ellipse.getCenterX() - Constants.MOVEMENT_OFFSET);
                    this.rectangle.setX(this.rectangle.getX() - Constants.MOVEMENT_OFFSET);
                }

                break;
            case 2:
                if (this.stripes[0].getX() + Constants.STRIPE_WIDTH < 1009) {
                    for (int i = 0; i < this.stripes.length; i++) {
                        this.stripes[i].setX(this.stripes[i].getX() + Constants.MOVEMENT_OFFSET);
                    }
                    this.ellipse.setCenterX(this.ellipse.getCenterX() + Constants.MOVEMENT_OFFSET);
                    this.rectangle.setX(this.rectangle.getX() + Constants.MOVEMENT_OFFSET);
                }

                break;
            case 3:
                if (this.stripes[7].getY() + Constants.STRIPE_HEIGHT < 700) {
                    for (int i = 0; i < this.stripes.length; i++) {
                        this.stripes[i].setY(this.stripes[i].getY() + Constants.MOVEMENT_OFFSET);
                    }
                    this.ellipse.setCenterY(this.ellipse.getCenterY() + Constants.MOVEMENT_OFFSET);
                    this.rectangle.setY(this.rectangle.getY() + Constants.MOVEMENT_OFFSET);

                }
                break;
            case 4:
                if (this.stripes[0].getY() > 0) {
                    for (int i = 0; i < this.stripes.length; i++) {
                        this.stripes[i].setY(this.stripes[i].getY() - Constants.MOVEMENT_OFFSET);
                    }
                    this.ellipse.setCenterY(this.ellipse.getCenterY() - Constants.MOVEMENT_OFFSET);
                    this.rectangle.setY(this.rectangle.getY() - Constants.MOVEMENT_OFFSET);
                }
                break;
            default:
                break;
        }
    }

    public void rotate() {
        //this is so janky lmfao
        for(int i = 0; i < this.stripes.length; i++){
            Color newColor;
            if (i+1 < this.stripes.length) newColor = this.stripes[i+1].getColor();
            else newColor = this.stripes[0].getColor();
            this.stripes[i].setColor(newColor);
        }
    }

    public void darken() {

        for (int i = 0; i < this.stripes.length; i++) {
            //if marshmallow stripe is certain distance from fire,
            if (this.stripes[i].getX() > Constants.FIRE_X_LEFT_OFFSET && this.stripes[i].getX() < Constants.FIRE_X_RIGHT_OFFSET){
                this.stripes[i].darken();
            }
        }

        //if ellipse is certain distance from fire,
        if (this.ellipse.getCenterX() > Constants.FIRE_X_LEFT_OFFSET && this.ellipse.getCenterX() < Constants.FIRE_X_RIGHT_OFFSET){
            Color color = (Color) this.ellipse.getFill();
            if (color == Color.WHITE) color = Color.OLDLACE;
            else color = color.deriveColor(0, 1.2, 0.95, 1);
            this.ellipse.setFill(color);
        }

    }

    public void setStripesColor(Color color) {
        for (int i = 0; i < this.stripes.length; i++) {
            //if marshmallow stripe is certain distance from fire,
            this.stripes[i].setColor(color);
        }
    }

    public double getX() {
        return this.rectangle.getX();
    }
}
