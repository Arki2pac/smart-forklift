package sample.astar;

/**
 * Created by Arkadiusz Chrobak on 08.05.2016.
 */
public class AstarPoints {
    private int X;
    private int Y;

    public AstarPoints() {

        this(0,0);
    }
    public AstarPoints(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    public int getX() {

        return X;
    }
    public int getY() {

        return Y;
    }
    // public String getXY() { return (X + ";" + Y); }
    public void setX(int X) {

        this.X = X;
    }
    public void setY(int Y) {

        this.Y = Y;
    }
}