package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattleshipView extends GridView implements MVVMView {

    private int mBattleshipSize;

    private Coordinate[] mCoordinates;

    private boolean[] mHitpoints;

    private boolean mSelected;

    private boolean mSank;

    private String mOrientation;

    private int mMainColor, mSelectionColor;
    // Paint for drawing a custom View
    private Paint mPaint;

    public BattleshipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BattleshipView, 0, 0);
        try {
            mMainColor = a.getColor(R.styleable.BattleshipView_shipMainColor, 0);
            mSelectionColor = a.getColor(R.styleable.BattleshipView_shipSelectionColor, 0);
            mOrientation = a.getString(R.styleable.BattleshipView_shipOrientation);
        } finally {
            a.recycle();
        }
        battleshipSetup();
        getBattleshipDetails();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);

        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();

        int cellWidth = viewWidth / mBattleshipSize;
        int cellHeight = viewHeight / mBattleshipSize;

        for (int i = 0; i < mBattleshipSize; i++) {
            mPaint.setColor(mMainColor);
            if (mOrientation.equals("horizontal")) {
                canvas.drawRect(i * cellWidth, 0,
                        (i + 1) * cellWidth, viewHeight, mPaint);
            }
            else if (mOrientation.equals("vertical")) {
                canvas.drawRect(0, i * cellHeight,
                        viewWidth, (i + 1) * cellHeight, mPaint);
            }
            // TODO: if hit, draw a red circle
            if (mHitpoints[i]) {
                int radius;
                int circleWidth = cellWidth / 2;
                int circleHeight = cellHeight / 2;

                if(circleWidth > circleHeight)
                    radius = circleHeight - 10;
                else
                    radius = circleWidth - 10;
                mPaint.setColor(Color.RED);
                canvas.drawCircle(circleWidth, viewHeight / 2, radius, mPaint);
            }
        }
        // Add the dividing lines to the grid
        mPaint.setColor(mSelectionColor);
        for (int i = 1; i < mBattleshipSize; i++) {
            if (mOrientation.equals("horizontal"))
                canvas.drawLine(i * cellWidth, 0, i * cellWidth, viewHeight, mPaint);
            else if (mOrientation.equals("vertical"))
                canvas.drawLine(0, i * cellHeight, viewWidth, i * cellHeight, mPaint);
        }
    }

    private void battleshipSetup() {
        mSelected = false;
        mSank = false;
    }

    private void getBattleshipDetails() {
        //TODO: Call VM and get the details for the Battleship
        mBattleshipSize = 3;
        mCoordinates = new Coordinate[]{new Coordinate(0,1),
                new Coordinate(0,2), new Coordinate(0,3)};
        mHitpoints = new boolean[]{false, false, false};
    }

    public void select() {
        mSelected = true;
        invalidate();
    }

    public void hit(int position) {
        mHitpoints[position] = true;
        invalidate();
    }

    public void sink() {
        for (int i = 0; i < mHitpoints.length; i++) {
            mHitpoints[i] = true;
        }
        mSank = true;
        invalidate();
    }
}
