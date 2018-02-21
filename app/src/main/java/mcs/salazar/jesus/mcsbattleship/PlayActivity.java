package mcs.salazar.jesus.mcsbattleship;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

/**
 * Created by berekethaile on 2/17/18.
 */

public class PlayActivity extends AppCompatActivity {

    String [] opponentsArray = {"Ivan", "Bereket"};
    SearchView mSearchView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.play_listview, opponentsArray);

        ListView listView = findViewById(R.id.opponent_list);
        listView.setAdapter(arrayAdapter);

        SearchManager searchViewManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView = findViewById(R.id.searchbox);
        mSearchView.setFocusableInTouchMode(true);
        mSearchView.setSearchableInfo(searchViewManager.getSearchableInfo(getComponentName()));

    }
}
