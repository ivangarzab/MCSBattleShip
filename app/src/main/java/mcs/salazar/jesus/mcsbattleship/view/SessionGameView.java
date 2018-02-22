package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import mcs.salazar.jesus.mcsbattleship.BattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.models.Battlefield;


/**
 * Created by Ivan on 2/14/2018
 */
public class SessionGameView extends LinearLayout implements MVVMView {

    private View mView;

    private BattlefieldView opponentField, playerField;

    public SessionGameView(Context context) {
        super(context);
    }

    public SessionGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSessionDetails();
        setupGameSession(context);
    }

    private void getSessionDetails() {
        //TODO: Call VM to get the details for the Session
    }

    private void setupGameSession(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.session_layout, this);

        opponentField = mView.findViewById(R.id.opponent_battlefield);
        opponentField.setAdapter(new BattlefieldAdapter(context,5));
        playerField = mView.findViewById(R.id.player_battlefield);
        playerField.setAdapter(new BattlefieldAdapter(context,5));
    }
}
