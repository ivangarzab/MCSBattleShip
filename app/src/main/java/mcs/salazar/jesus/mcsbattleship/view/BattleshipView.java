package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattleshipView extends LinearLayout implements MVVMView {

    private Context mContext;

    private int mShipSize;

    private Coordinate[] mCoordinates;

    private boolean[] mHitpoints;

    public BattleshipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        // Look for custom attributes assigned during the initialization time
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.BattleshipView, 0, 0);
        try {
            mShipSize = a.getInt(R.styleable.BattleshipView_shipSize, 0);
        } finally {
            a.recycle();
        }

        // This call may be redundant?  There's nothing being drawn here!
        setupBattleship(/*context*/);
    }

    private void setupBattleship(/*Context context*/) {
        // Create Battleship through Image Resources
        for (int i = 0; i < mShipSize; i++) {
            ImageView imageView = new ImageView(mContext);
            if (getOrientation() == LinearLayout.HORIZONTAL) {
                imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //TODO: Use Horizontal Assets
                imageView.setImageResource(R.drawable.sample_0);
                addView(imageView);
            } else if (getOrientation() == LinearLayout.VERTICAL) {
                imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                        LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //TODO: Use Vertical Assets (images for front, middle and back of ship)
                imageView.setImageResource(R.drawable.sample_0);
                addView(imageView);
            }
            imageView.setTag(i);
        }
    }

    public int getShipSize() {
        return this.mShipSize;
    }

    public void setShipSize(int size) {
        this.mShipSize = size;
        setupBattleship();
    }
}
