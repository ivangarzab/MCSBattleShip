package mcs.salazar.jesus.mcsbattleship;

import java.util.ArrayList;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battleship extends Model {

    private int mSize;
    private boolean[] mHitpoints;
    private ArrayList<int[][]> mCoordinates;
    private boolean mSunk;

    public Battleship(int size) {
        mSize = size;
        mHitpoints = new boolean[mSize];
        mCoordinates = new ArrayList<>(mSize);
        mSunk = false;
    }
}
