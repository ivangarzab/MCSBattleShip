package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.adapter.OpponentBattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.contracts.SessionContract;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 2/23/2018
 */
public class BattlefieldInGameOpponentViewModel extends BattlefieldInGameViewModel {

    private SessionContract mCallback;

    public BattlefieldInGameOpponentViewModel(Context context, Battlefield battlefield) {
        super(context, battlefield);
        if (context instanceof SessionContract) {
            mCallback = (SessionContract)context;
        }
    }

    @Override
    public void createAdapter(Context context) {
        mAdapter = new OpponentBattlefieldAdapter(context,
                mBattlefield.getSize(), mBattlefield.getGrid(), mBattlefield.getShots());
    }

    public AdapterView.OnItemClickListener getItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // if it not the player's turn, return
                //if (mCallback.isItMyTurn()) return;

                boolean[][] grid = mBattlefield.getGrid();
                int size = mBattlefield.getSize();
                if (grid[i/ size][i % size]) {
                    takeShot(view, i, size, true);
                } else {
                    takeShot(view, i, size, false);
                }
                // Update Session & store it
                mCallback.storeSession(mBattlefield);
            }
        };
    }

    private void takeShot(View view, int position, int size, boolean hit) {
        // Save shot taken locally
        boolean[][] shots = mBattlefield.getShots();
        shots[position/ size][position % size] = true;
        this.mBattlefield.setShots(shots);
        // Draw the ImageView accordingly
        ColorDrawable cd;
        if (hit) {
            cd = new ColorDrawable(view.getResources()
                    .getColor(R.color.colorOpponentHit));
        } else {
            cd = new ColorDrawable(view.getResources()
                    .getColor(R.color.colorOpponentMiss));
        }
        view.setBackground(cd);
    }
}
