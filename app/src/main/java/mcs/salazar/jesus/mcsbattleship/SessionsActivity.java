package mcs.salazar.jesus.mcsbattleship;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by berekethaile on 2/17/18.
 */

public class SessionsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    private ArrayList<String> opponents = new ArrayList<>(Arrays.asList( "Ivan", "bereket", "winta"));
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessions_activity);
        mRecyclerView = findViewById(R.id.my_opponent_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new OpponentsAdapter(opponents, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

    }
}
