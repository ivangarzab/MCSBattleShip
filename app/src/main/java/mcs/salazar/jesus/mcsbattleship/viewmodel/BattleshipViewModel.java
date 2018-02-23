package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.arch.lifecycle.ViewModel;

import mcs.salazar.jesus.mcsbattleship.models.Battleship;

/**
 * Created by Ivan on 2/22/2018
 */

public class BattleshipViewModel extends ViewModel implements MVVMViewModel {

    private Battleship mBattleship;

    public BattleshipViewModel(Battleship battleship) {
        this.mBattleship = battleship;
    }

    @Override
    public void bind() {

    }
}
