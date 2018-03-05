package mcs.salazar.jesus.mcsbattleship.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;


/**
 * Created by berekethaile on 2/14/18.
 */

public class PlayerDashboardActivity extends AppCompatActivity {

    public static String SESSION_EXTRA = "SESSION_EXTRA";

    @BindView(R.id.name_game) Button mPlay;

    @BindView(R.id.my_scores) Button mScores;

    @BindView(R.id.sessions) Button mSessions;

    @BindView(R.id.friends) Button mFriends;

    @BindView(R.id.sign_out) ImageButton mSignout;

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // Bind ButterKnife!
        ButterKnife.bind(this);


        mFirebaseAuth = FirebaseAuth.getInstance();

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerDashboardActivity.this,
                        InGameActivity.class);
                //Bundle bundle = new Bundle()
                intent.putExtra(SESSION_EXTRA, getSessionFromSharedPreferences());
                startActivity(intent);
            }
        });

        mScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashboardActivity.this,
                        ScoresActivity.class));
            }
        });

        mSessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashboardActivity.this,
                        SessionsActivity.class));
            }
        });

        mFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashboardActivity.this,
                        FriendsActivity.class));
            }
        });

        mSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                finish();
            }
        });
    }


    private Session getSessionFromSharedPreferences() {
        final SharedPreferences mSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        Gson gson = new Gson();
        String value = mSharedPreferences.getString("MySession", "");
        Session session= gson.fromJson(value, Session.class);

        if (mFirebaseAuth.getCurrentUser().getEmail().equals(session.getPlayer().getEmail())){
            return session;
        } else {
            // Switch Player & Opponent
            User newUser = session.getPlayer();
            session.setPlayer(session.getOpponent());
            session.setOpponent(newUser);
            // Switch PlayerBattlefield & OpponentBattlefield
            Battlefield newBattlefield = session.getPlayerBattlefield();
            session.setPlayerBattlefield(session.getOpponentBattlefield());
            session.setOpponentBattlefield(newBattlefield);
            return session;
        }
    }

    private void signOut() {
        mFirebaseAuth.signOut();
    }

}
