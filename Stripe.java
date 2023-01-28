package campfire;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Stripe {

    private Rectangle rectangle;
    private Color color;

    public Stripe(){
        this.color = Color.BLACK;
        this.rectangle = new Rectangle(Constants.STRIPE_WIDTH, Constants.STRIPE_HEIGHT, this.color);

    }
    public void darken(){
        //not sure if this will be good; FLORALWHITE might need to change too
        if (this.color == Color.WHITE) this.color = Color.FLORALWHITE;
        else this.color = Color.WHITE.darker();
    }
    public void setX(double loc){
        this.rectangle.setX(loc);
    }

    public void setY(double loc){
        this.rectangle.setY(loc);
    }

    public double getX(){
        return this.rectangle.getX();
    }

    public double getY(){
        return this.rectangle.getY();
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }
}
