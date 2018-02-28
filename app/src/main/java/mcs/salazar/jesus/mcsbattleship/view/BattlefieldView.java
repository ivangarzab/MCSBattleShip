package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridView;

import mcs.salazar.jesus.mcsbattleship.BattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/14/2018
 */
public class BattlefieldView extends GridView implements MVVMView {

    public int mFieldSize;

    public BattlefieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Look for custom attributes assigned during the initialization time
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.BattleshipView, 0, 0);
        try {
            mFieldSize = a.getInt(R.styleable.BattleshipView_shipSize, 0);
        } finally {
            a.recycle();
        }
        //setupBattlefield();
    }

    private void setupBattlefield() {
        this.setNumColumns(mFieldSize);
        this.setGravity(Gravity.CENTER);
        this.setStretchMode(STRETCH_COLUMN_WIDTH);
        //createAdapter();
    }

    public int getFieldSize() {
        return this.mFieldSize;
    }

    public void setFieldSize(int size) {
        this.mFieldSize = size;
        setupBattlefield();
    }
}
