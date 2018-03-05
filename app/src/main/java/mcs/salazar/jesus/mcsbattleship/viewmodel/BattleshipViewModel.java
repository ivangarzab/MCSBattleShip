package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.model.Battleship;

/**
 * Created by Ivan on 2/22/2018
 */

public class BattleshipViewModel implements MVVMViewModel {

    private Battleship mBattleship;

    private int mHitsLeft;

    private boolean mSank;

    public BattleshipViewModel(Battleship battleship) {
        this.mBattleship = battleship;
        mHitsLeft = mBattleship.getShipSize();
        mSank = false;
    }

    public int getShipSize() { return this.mBattleship.getShipSize(); }

    public void setShipSize(int size) { this.mBattleship.setShipSize(size); }

    public View.OnClickListener onShipClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHitsLeft > 0) {
                    ImageView child = (ImageView) (((ViewGroup) view)
                            .getChildAt(mHitsLeft - 1));
                    //TODO: Change current image of child to the hit image
                    child.setImageResource(R.drawable.sample_1);
                    mHitsLeft--;
                }
                if (mHitsLeft == 0) {
                    mSank = true;
                    Toast.makeText(view.getContext(), "SHIP SANK!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        };
    }
}
