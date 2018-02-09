package mcs.salazar.jesus.mcsbattleship.models;

/**
 * Created by Ivan on 2/8/2018
 */
public class Coordinate implements Model {
    public  int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void toJson() {

    }

    @Override
    public void fromJson() {

    }
}
