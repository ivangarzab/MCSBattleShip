package mcs.salazar.jesus.mcsbattleship.activity;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.google.gson.Gson;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.contracts.SessionContract;
import mcs.salazar.jesus.mcsbattleship.databinding.ActivityInGameBinding;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;
import mcs.salazar.jesus.mcsbattleship.util.InGameUtil;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.SessionGameViewModel;

public class InGameActivity extends AppCompatActivity implements SessionContract {

    private Session mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create SessionGameView bind to ViewModel which contains Model
        ActivityInGameBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_in_game);

        mSession = new Session(new User(), new User());
        //TODO MOCKS: Create/add mock Battlefields
        Battlefield b1 = mSession.getOpponentBattlefield();
        b1.setGrid(new boolean[][]{{true, true, true, false, false, false},
                {false, false, false, true, false, false},
                {true, false, false, true, false, false},
                {true, false, false, true, false, true},
                {true, false, false, false, false, true},
                {false, true, true, true, false, true}});
        b1.setShots(new boolean[][]{{false, false, false, false, false, false},
                {true, false, false, false, true, false},
                {false, false, false, false, false, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, true}});
        mSession.setOpponentBattlefield(b1);

        Battlefield b2 = mSession.getPlayerBattlefield();
        b2.setGrid(new boolean[][]{{true, true, true, false, false, false},
                {false, false, false, true, false, false},
                {true, false, false, true, false, false},
                {true, false, false, true, false, true},
                {true, false, false, false, false, true},
                {false, true, true, true, false, true}});
        b2.setShots(new boolean[][]{{true, true, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, true, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {true, false, false, false, false, false}});
        mSession.setPlayerBattlefield(b2);
        mSession.setNextTurn(mSession.getPlayer());

        // Set ViewModel for SessionView
        binding.setViewmodel(new SessionGameViewModel(mSession));

        // Bind Opponent Battlefield
        InGameUtil.bindOpponentBattlefield(this,
                binding.getViewmodel().getOpponentBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_opponent_battlefield));

        // Bind Game Actions
        InGameUtil.bindInGameActions(this,
                (ViewGroup) findViewById(R.id.session_game_actions));

        // Bind Player Battlefield
        InGameUtil.bindPlayerBattlefield(this,
                binding.getViewmodel().getPlayerBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_player_battlefield));
    }

    @Override
    public void onBackPressed() {
        InGameUtil.displayExitWarning(this);
    }

    @Override
    public boolean isItMyTurn() {
        if (mSession.getNextTurn().equals(mSession.getPlayer())) return true;
        else return false;
    }

    @Override
    public void storeSession(Battlefield opponent) {
        // Update Session before storing
        this.mSession.setNextTurn(this.mSession.getOpponent());
        this.mSession.setOpponentBattlefield(opponent);
        // Saved on Shared Preferences
        SharedPreferences mSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mSession);
        editor.putString("MySession", json);
        editor.apply();
    }
}
