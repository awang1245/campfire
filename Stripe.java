package campfire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stripe {

    private Rectangle rectangle;
    private Color color;

    public Stripe() {
        this.color = Color.WHITE;
        this.rectangle = new Rectangle(Constants.STRIPE_WIDTH, Constants.STRIPE_HEIGHT, this.color);

    }

    public void darken() {
        if (this.color == Color.WHITE) this.color = Color.OLDLACE;
        else this.color = this.color.deriveColor(0, 1.2, 0.95, 1);
        this.rectangle.setFill(this.color);
    }

    public void setX(double loc) {
        this.rectangle.setX(loc);
    }

    public void setY(double loc) {
        this.rectangle.setY(loc);
    }

    public double getX() {
        return this.rectangle.getX();
    }

    public double getY() {
        return this.rectangle.getY();
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
}
