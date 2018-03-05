package mcs.salazar.jesus.mcsbattleship.contracts;

import mcs.salazar.jesus.mcsbattleship.model.Battlefield;

/**
 * Created by Ivan on 3/4/2018
 */
public interface SessionContract {
    boolean isItMyTurn();
    void storeSession(Battlefield opponent);
}
