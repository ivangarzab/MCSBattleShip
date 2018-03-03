package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.adapter.OpponentBattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.adapter.PlayerBattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 2/23/2018
 */
public class BattlefieldInGameOpponentViewModel extends BattlefieldInGameViewModel {

    public BattlefieldInGameOpponentViewModel(Context context, Battlefield battlefield) {
        super(context, battlefield);
    }

    @Override
    public void createAdapter(Context context) {
        mAdapter = new OpponentBattlefieldAdapter(context,
                mBattlefield.getSize(), mBattlefield.getGrid());
    }

    public AdapterView.OnItemClickListener getItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                boolean[][] grid = mBattlefield.getGrid();
                int size = mBattlefield.getSize();
                if (grid[i/ size][i % size]) {
                    view.setBackground(new ColorDrawable(view.getResources()
                            .getColor(R.color.colorOpponentHit)));
                } else {
                    view.setBackground(new ColorDrawable(view.getResources()
                            .getColor(R.color.colorOpponentMiss)));
                }
            }
        };
    }

    @Override
    public void bind() {
        super.bind();
    }
}
