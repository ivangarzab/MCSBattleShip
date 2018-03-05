package mcs.salazar.jesus.mcsbattleship.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.databinding.ActivityInGameBinding;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;
import mcs.salazar.jesus.mcsbattleship.util.InGameUtil;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.SessionGameViewModel;

public class InGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create SessionGameView bind to ViewModel which contains MVVMModel
        ActivityInGameBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_in_game);

        Session session = new Session(new User(), new User());
        binding.setViewmodel(new SessionGameViewModel(session));



        //TODO MOCKS: Create/add mock Battlefields
        Battlefield b1 = session.getOpponentBattlefield();
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
        session.setOpponentBattlefield(b1);

        Battlefield b2 = session.getPlayerBattlefield();
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
        session.setPlayerBattlefield(b2);



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
}
