package mcs.salazar.jesus.mcsbattleship;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by berekethaile on 2/17/18.
 */

public class FriendsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    private ArrayList<String> opponents = new ArrayList<>(Arrays.asList( "Ivan", "bereket", "winta"));
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_activity);

        mRecyclerView = findViewById(R.id.my_opponent_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new OpponentsAdapter(opponents, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }
}

