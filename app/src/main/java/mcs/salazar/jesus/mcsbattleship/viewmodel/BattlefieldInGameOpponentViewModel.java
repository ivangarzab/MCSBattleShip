package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;

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

    @Override
    public void bind() {
        super.bind();
    }
}
