package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.GridView;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattlefieldView extends GridView {

    private int mBattlefieldSize;

    private boolean[][] mGrid;

    private int mMainColor, mSecondColor, mDetailColor;
    // Paint for drawing a custom View
    private Paint mPaint;

    public BattlefieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.BattlefieldView, 0, 0);
        try {
            mMainColor = a.getColor(R.styleable.BattlefieldView_gridMainColor, 0);
            mSecondColor = a.getColor(R.styleable.BattlefieldView_gridSecondColor, 0);
            mDetailColor = a.getColor(R.styleable.BattlefieldView_gridDetailColor, 0);
        } finally {
            a.recycle();
        }
        getBattlefieldDetails();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(1);

        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();

        int cellWidth = viewWidth / mBattlefieldSize;
        int cellHeight = viewHeight / mBattlefieldSize;
        // Create the grid cells
        for (int i = 0; i < mBattlefieldSize; i++) {
            for (int j = 0; j < mBattlefieldSize; j++) {
                // If the cell == true, paint differently for contrast
                if (mGrid[j][i]) {
                    mPaint.setColor(mSecondColor);
                    canvas.drawRect(i * cellWidth, j * cellHeight,
                            (i + 1) * cellWidth, (j + 1) * cellHeight, mPaint);
                }
                else {
                    mPaint.setColor(mMainColor);
                    canvas.drawRect(i * cellWidth, j * cellHeight,
                            (i + 1) * cellWidth, (j + 1) * cellHeight, mPaint);
                }
            }
        }
        // Add the dividing lines to the grid
        mPaint.setColor(mDetailColor);
        for (int i = 1; i < mBattlefieldSize; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, viewHeight, mPaint);
            canvas.drawLine(0, i * cellHeight, viewWidth, i * cellHeight, mPaint);
        }
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

    public void changeColor() {

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
        invalidate();
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int column = (int)(event.getX() / cellWidth);
            int row = (int)(event.getY() / cellHeight);

            cellChecked[column][row] = !cellChecked[column][row];
            invalidate();
        }

        return true;
    }*/
}
