package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridView;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattlefieldView extends GridView implements MVVMView {

    // Mock default grid images
    public static Integer[] mThumbImages = {
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0, R.drawable.sample_0,
            R.drawable.sample_0
    };

    // Mock grid status
    public static boolean[][] mGrid;

    public static int mBattlefieldSize;

    public BattlefieldView(Context context) {
        super(context);
        getBattlefieldDetails();
        setupBattlefield();
    }

    public BattlefieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getBattlefieldDetails();
        setupBattlefield();
    }

    public BattlefieldView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void getBattlefieldDetails() {
        //TODO: Call VM and get the details for the Battlefield
        mBattlefieldSize = 5;
        mGrid = new boolean[][]{{false, true, false, true, false},
                {false, true, false, true, false},
                {false, false, false, true, false},
                {false, false, false, false, false},
                {false, true, true, true, true}};
    }

    /** Default setup for Battlefield */
    private void setupBattlefield() {
        this.setNumColumns(mBattlefieldSize);
        this.setGravity(Gravity.CENTER);
        this.setStretchMode(STRETCH_COLUMN_WIDTH);
    }

    public void selectCell(Coordinate selection) {
        //TODO: Change selection Coordinate's color and the cells adjacent to it
    }

    public void addShip(Coordinate[] location) {
        // Should we ask for a Battleship object instead?
    }

    public void removeShip(Coordinate[] location) {
        // Should we ask for a Battleship object instead?
    }

    public void addShot(Coordinate shot) {
        mGrid[shot.y][shot.x] = true;
        //TODO: Let the Adapter know that there was a change after checking if Util.didItHit()
    }
}
