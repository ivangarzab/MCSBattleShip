package mcs.salazar.jesus.mcsbattleship.viewmodel;

import mcs.salazar.jesus.mcsbattleship.models.Battleship;

/**
 * Created by Ivan on 2/22/2018
 */

public class BattleshipViewModel implements MVVMViewModel {

    private Battleship mBattleship;

    public BattleshipViewModel(Battleship battleship) {
        this.mBattleship = battleship;
    }


}
