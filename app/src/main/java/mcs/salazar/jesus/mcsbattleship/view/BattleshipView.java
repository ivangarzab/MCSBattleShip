package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattleshipView extends LinearLayout implements MVVMView {

    private int mSize;

    private Coordinate[] mCoordinates;

    private boolean[] mHitpoints;

    private boolean mSelected;

    private boolean mSank;

    private int mMainColor;

    public BattleshipView(Context context, AttributeSet attrs) {
        super(context, attrs);

        getBattleshipDetails();
        setupBattleship(context);
    }

    private void setupBattleship(Context context) {
        mSelected = false;
        mSank = false;

        // Create Battleship through Image Resources
        for (int i = 0; i < mSize; i ++) {
            if (getOrientation() == LinearLayout.HORIZONTAL) {
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //TODO: Use Horizontal Assets
                imageView.setImageResource(R.drawable.sample_0);
                addView(imageView);
            }
            else if (getOrientation() == LinearLayout.VERTICAL) {
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //TODO: Use Vertical Assets (images for front, middle and back of ship)
                imageView.setImageResource(R.drawable.sample_0);
                addView(imageView);
            }
        }
    }

    private void getBattleshipDetails() {
        //TODO: Call VM and get the details for the Battleship
        mSize = 3;
        mCoordinates = new Coordinate[]{new Coordinate(0,1),
                new Coordinate(0,2), new Coordinate(0,3)};
        mHitpoints = new boolean[]{false, false, false};
    }

    public int getMainColor() {
        return mMainColor;
    }

    public void setMainColor(int color) {
        mMainColor = color;
    }

    public void select() {
        mSelected = true;
    }

    public void hit(int position) {
        mHitpoints[position] = true;
    }

    public void sink() {
        for (int i = 0; i < mHitpoints.length; i++) {
            mHitpoints[i] = true;
        }
        mSank = true;
    }
}
