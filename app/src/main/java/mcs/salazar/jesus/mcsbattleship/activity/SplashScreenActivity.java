package mcs.salazar.jesus.mcsbattleship.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mcs.salazar.jesus.mcsbattleship.R;

/**
 * Created by berekethaile on 2/14/18.
 */

public class SplashScreenActivity extends AppCompatActivity {

    protected boolean active = true;
    protected int splashTime = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread splashThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    int waited = 0;
                    while (active && (waited < splashTime)) {
                        sleep(100);
                        if (active) {
                            waited += 100;
                        }
                    }

                }catch (Exception e) {

                }finally {
                    // Create an intent that will forward to the login activity
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        splashThread.start();

    }
}

