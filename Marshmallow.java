package campfire;

public class Marshmallow {

    public Marshmallow(){
        this.setupShape();
    }

    private void setupShape(){

    }

    public void move(int direction){
        switch(direction) {
            case 1:
                //for all sides:
                //this.sides.setX(this.sides.getX() - Constants.MOVEMENT_OFFSET);
                break;
            case 2:
                //for all sides:
                //this.sides.setX(this.sides.getX() + Constants.MOVEMENT_OFFSET);
                break;
            case 3:
                //for all sides:
                //this.sides.setY(this.sides.getY() + Constants.MOVEMENT_OFFSET);
                break;
            case 4:
                //for all sides:
                //this.sides.setY(this.sides.getY() - Constants.MOVEMENT_OFFSET);
                break;
            default:
                break;
        }
    }

    public void rotate(){

    }
}
