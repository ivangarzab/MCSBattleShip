package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import mcs.salazar.jesus.mcsbattleship.models.Battlefield;

/**
 * Created by Ivan on 2/14/2018
 */
public class SessionGameView extends LinearLayout implements MVVMView {

    // Paint for drawing a custom View
    private Paint mPaint;

    public SessionGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        getSessionDetails();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void getSessionDetails() {
        //TODO: Call VM to get the details for the Session
    }
}
