package mcs.salazar.jesus.mcsbattleship.models;

/**
 * Created by Ivan on 2/8/2018
 */
public class Coordinate implements Model {
    private int mX;
    private int mY;

    public Coordinate(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    @Override
    public void toJson() {

    }

    @Override
    public void fromJson() {

    }
}
