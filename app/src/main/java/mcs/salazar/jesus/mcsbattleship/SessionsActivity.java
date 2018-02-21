package mcs.salazar.jesus.mcsbattleship;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

/**
 * Created by berekethaile on 2/17/18.
 */

public class SessionsActivity extends AppCompatActivity {

    String [] sessions = {"Ivan", "Bereket"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessions_activity);
        ListView listView = findViewById(R.id.sessions_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.sessions_listview, sessions);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NewGameMenu.class);
                startActivity(intent);
            }
        });

    }
}
