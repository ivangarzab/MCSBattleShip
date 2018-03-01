package mcs.salazar.jesus.mcsbattleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by berekethaile on 2/17/18.
 */

public class PlayActivity extends AppCompatActivity {

    //SearchView mSearchView;

    private Button mNewGame, mSessions, mScores, mFriends;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

//        mNewGame = findViewById(R.id.n_game);
//        mSessions = findViewById(R.id.session);
//        mScores = findViewById(R.id.score);
//        mFriends = findViewById(R.id.friend);
        Intent intent = new Intent(PlayActivity.this, BattleField_Board.class);
        startActivity(intent);

//        mNewGame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PlayActivity.this, BattleField_Board.class);
//                startActivity(intent);
//            }
//        });


        // Search friends feature

        /*SearchManager searchViewManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView = findViewById(R.id.searchbox);
        mSearchView.setFocusableInTouchMode(true);
        mSearchView.setSearchableInfo(searchViewManager.getSearchableInfo(getComponentName()));*/

    }
}
