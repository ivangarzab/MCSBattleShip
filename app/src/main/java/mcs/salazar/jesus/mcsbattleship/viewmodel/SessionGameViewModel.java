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

    public User getChallenger() {
        return this.mSession.getChallenger();
    }

    public void setChallenger(User challenger) {
        this.mSession.setChallenger(challenger);
    }

    public Battlefield getChallengerBattlefield() {
        return this.mSession.getChallengerBattlefield();
    }

    public void setChallengerBattlefield(Battlefield challengerBattlefield) {
        this.mSession.setChallengerBattlefield(challengerBattlefield);
    }

    public User getChallengee() {
        return this.mSession.getChallengee();
    }

    public void setChallengee(User challengee) {
        this.mSession.setChallengee(challengee);
    }

    public Battlefield getChallengeeBattlefield() {
        return this.mSession.getChallengeeBattlefield();
    }

    public void setChallengeeBattlefield(Battlefield challengeeBattlefield) {
        this.mSession.setChallengeeBattlefield(challengeeBattlefield);
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

    @Override
    public void bind() {

    }
}
