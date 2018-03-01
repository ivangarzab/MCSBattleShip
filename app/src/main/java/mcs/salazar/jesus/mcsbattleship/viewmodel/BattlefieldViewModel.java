package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;

import mcs.salazar.jesus.mcsbattleship.BattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 2/23/2018
 */
public class BattlefieldViewModel implements MVVMViewModel {

    private Battlefield mBattlefield;
    BattlefieldAdapter mAdapter;

    public BattlefieldViewModel(Context context, Battlefield battlefield) {
        this.mBattlefield = battlefield;
        mAdapter = new BattlefieldAdapter(context, mBattlefield.getSize(), mBattlefield.getGrid());
    }

    public int getFieldSize() {
        return this.mBattlefield.getSize();
    }

    public void setFieldSize(int size) {
        mBattlefield.setSize(size);
    }

    public BattlefieldAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void bind() {

    }
}
