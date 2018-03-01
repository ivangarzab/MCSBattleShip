package mcs.salazar.jesus.mcsbattleship.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import mcs.salazar.jesus.mcsbattleship.R;


/**
 * Created by Ivan on 2/14/2018
 */
public class SessionGameView extends LinearLayout implements MVVMView {

    public SessionGameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupGameSession(context);
    }

    private void setupGameSession(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.session_game_layout, this);
        }
        /*
        opponentField = mView.findViewById(R.id.opponent_battlefield);
        //opponentField.setAdapter(new PlayerBattlefieldAdapter(context, 5));
        playerField = mView.findViewById(R.id.player_battlefield);
        //playerField.setAdapter(new PlayerBattlefieldAdapter(context,5));
        */
    }
}
