package mcs.salazar.jesus.mcsbattleship;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mcs.salazar.jesus.mcsbattleship.models.Battlefield;

/**
 * Created by berekethaile on 2/20/18.
 */

public class NewGameMenu extends AppCompatActivity {

    Button mContinue, mSurrender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game_menu);

        mContinue = findViewById(R.id.cont);
        mSurrender = findViewById(R.id.surr);

        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGameMenu.this, BattleField_Board.class);
                startActivity(intent);
            }
        });
    }
}
