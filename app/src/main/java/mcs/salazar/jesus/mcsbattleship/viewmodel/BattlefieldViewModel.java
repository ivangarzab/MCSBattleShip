package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;
import android.widget.BaseAdapter;

import mcs.salazar.jesus.mcsbattleship.adapter.PlayerBattlefieldAdapter;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 2/23/2018
 */
public abstract class BattlefieldViewModel implements MVVMViewModel {

    public Battlefield mBattlefield;

    public BaseAdapter mAdapter;

    public BattlefieldViewModel(Context context, Battlefield battlefield) {
        this.mBattlefield = battlefield;
        createAdapter(context);
    }

    public int getFieldSize() {
        return this.mBattlefield.getSize();
    }

    public void setFieldSize(int size) {
        mBattlefield.setSize(size);
    }

    public BaseAdapter getAdapter() {
        return mAdapter;
    }

    public abstract void createAdapter(Context context);
}
