package mcs.salazar.jesus.mcsbattleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by berekethaile on 2/14/18.
 */

public class PlayerDashBoard extends AppCompatActivity {

    private Button mPlay, mScores, mSessions, mFriends, mSignout;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mPlay = findViewById(R.id.name_game);
        mScores = findViewById(R.id.my_scores);
        mSessions = findViewById(R.id.sessions);
        mFriends = findViewById(R.id.friends);
        mSignout = findViewById(R.id.sign_out);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashBoard.this, BattleField_Board.class));
            }
        });

        mScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashBoard.this, ScoresActivity.class));
            }
        });

        mSessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashBoard.this, SessionsActivity.class));
            }
        });

        mFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerDashBoard.this, FriendsActivity.class));
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

    private void signOut() {
        mFirebaseAuth.signOut();
    }

}
