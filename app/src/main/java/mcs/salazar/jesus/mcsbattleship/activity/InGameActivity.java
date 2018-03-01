package mcs.salazar.jesus.mcsbattleship.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.databinding.ActivityInGameBinding;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;
import mcs.salazar.jesus.mcsbattleship.util.InGameUtil;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.SessionGameViewModel;

public class InGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create SessionGameView bind to ViewModel which contains Model
        ActivityInGameBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_in_game);
        binding.setViewmodel(new SessionGameViewModel(new Session(new User(), new User())));

        // Bind OpponentBattlefield
        InGameUtil.bindOpponentBattlefield(this,
                binding.getViewmodel().getOpponentBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_opponent_battlefield));

        //TODO: Create and bind game_actions_layout's click listeners

        // Bind PlayerBattlefield
        InGameUtil.bindPlayerBattlefield(this,
                binding.getViewmodel().getPlayerBattlefield(),
                (BattlefieldView) findViewById(R.id.session_game_player_battlefield));
    }
}
