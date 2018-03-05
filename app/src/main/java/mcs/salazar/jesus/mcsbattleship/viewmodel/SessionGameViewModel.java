package mcs.salazar.jesus.mcsbattleship.viewmodel;

import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Session;
import mcs.salazar.jesus.mcsbattleship.model.User;

/**
 * Created by Ivan on 2/23/2018
 */
public class SessionGameViewModel implements MVVMViewModel {

    private Session mSession;

    public SessionGameViewModel(Session session) {
        this.mSession = session;
    }

    public User getOpponent() {
        return this.mSession.getOpponent();
    }

    public void setOpponent(User opponent) {
        this.mSession.setOpponent(opponent);
    }

    public Battlefield getOpponentBattlefield() {
        return this.mSession.getOpponentBattlefield();
    }

    public void setOpponentBattlefield(Battlefield opponentBattlefield) {
        this.mSession.setOpponentBattlefield(opponentBattlefield);
    }

    public User getPlayer() {
        return this.mSession.getPlayer();
    }

    public void setPlayer(User player) {
        this.mSession.setPlayer(player);
    }

    public Battlefield getPlayerBattlefield() {
        return this.mSession.getPlayerBattlefield();
    }

    public void setPlayerBattlefield(Battlefield playerBattlefield) {
        this.mSession.setPlayerBattlefield(playerBattlefield);
    }

    public User getNextTurn() {
        return this.mSession.getNextTurn();
    }

    public void setNextTurn(User nextTurn) {
        this.mSession.setNextTurn(nextTurn);
    }

    public int getTotalTurns() {
        return this.mSession.getTotalTurns();
    }

    public void setTotalTurns(int totalTurns) {
        this.mSession.setTotalTurns(totalTurns);
    }
}
