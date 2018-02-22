package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mcs.salazar.jesus.mcsbattleship.R;

/**
 * Created by Ivan on 2/21/2018
 */

public class SessionThumbView extends RelativeLayout implements MVVMView {

    private View mView;

    private String mOpponent, mDateStarted;
    private int mTurnNumber;
    private boolean mMyTurn;

    public SessionThumbView(Context context) {
        super(context);
    }

    public SessionThumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSessionDetails();
        setupThumbSession(context);
    }

    private void getSessionDetails() {
        //TODO: Call VM to get the details for the Session
        mOpponent = "v. Ivan";
        mDateStarted = "02/21/2018";
        mTurnNumber = 6;
        mMyTurn = true;
    }

    private void setupThumbSession(Context context) {
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.session_thumb_layout, this);


        ((TextView)mView.findViewById(R.id.session_thumb_opponent_textView)).setText(mOpponent);
        ((TextView)mView.findViewById(R.id.session_thumb_date_textView)).setText(mDateStarted);
        String turnNumber = "Turn #" + mTurnNumber;
        ((TextView)mView.findViewById(R.id.session_thumb_turn_number_textView)).setText(turnNumber);
        if (mMyTurn) {
            String nextTurn = "YOUR TURN";
            ((TextView)mView.findViewById(R.id.session_thumb_next_turn_textView)).setText(nextTurn);
        }
        else {
            String nextTurn = "HIS TURN";
            ((TextView)mView.findViewById(R.id.session_thumb_next_turn_textView)).setText(nextTurn);
        }

        //TODO: findViewById the ImageView and place a random Image Resource from the grid images
    }
}
