package mcs.salazar.jesus.mcsbattleship.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ivan on 2/5/2018
 */
public class Session implements Model, Parcelable {

    private final static int BATTLEFIELD_SIZE = 8;
    private final static int BATTLESHIPS_PER_PLAYER = 4;

    private User mChallenger;
    private Battlefield mChallengerBattlefield;
    private User mChallengee;
    private Battlefield mChallengeeBattlefield;
    private User mNextTurn;
    private int mTotalTurns;
    private String mDateStarted;
    private String mDateFinished;

    public Session(User challenger, User challengee) {
        mChallenger = challenger;
        mChallengerBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mChallengee = challengee;
        mChallengeeBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mNextTurn = mChallengee;
        mTotalTurns = 0;
        // Get today's date
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        mDateStarted = df.format(c.getTime());
        mDateFinished = "";
    }

    protected Session(Parcel in) {
        mChallenger = in.readParcelable(User.class.getClassLoader());
        mChallengerBattlefield = in.readParcelable(Battlefield.class.getClassLoader());
        mChallengee = in.readParcelable(User.class.getClassLoader());
        mChallengeeBattlefield = in.readParcelable(Battlefield.class.getClassLoader());
        mNextTurn = in.readParcelable(User.class.getClassLoader());
        mTotalTurns = in.readInt();
        mDateStarted = in.readString();
        mDateFinished = in.readString();
    }

    public static final Creator<Session> CREATOR = new Creator<Session>() {
        @Override
        public Session createFromParcel(Parcel in) {
            return new Session(in);
        }

        @Override
        public Session[] newArray(int size) {
            return new Session[size];
        }
    };

    public User getChallenger() {
        return mChallenger;
    }

    public void setChallenger(User challenger) {
        mChallenger = challenger;
    }

    public Battlefield getChallengerBattlefield() {
        return mChallengerBattlefield;
    }

    public void setChallengerBattlefield(Battlefield challengerBattlefield) {
        mChallengerBattlefield = challengerBattlefield;
    }

    public User getChallengee() {
        return mChallengee;
    }

    public void setChallengee(User challengee) {
        mChallengee = challengee;
    }

    public Battlefield getChallengeeBattlefield() {
        return mChallengeeBattlefield;
    }

    public void setChallengeeBattlefield(Battlefield challengeeBattlefield) {
        mChallengeeBattlefield = challengeeBattlefield;
    }

    public User getNextTurn() {
        return mNextTurn;
    }

    public void setNextTurn(User nextTurn) {
        mNextTurn = nextTurn;
    }

    public int getTotalTurns() {
        return mTotalTurns;
    }

    public void setTotalTurns(int totalTurns) {
        mTotalTurns = totalTurns;
    }

    public String getDateStarted() {
        return mDateStarted;
    }

    public void setDateStarted(String dateStarted) {
        mDateStarted = dateStarted;
    }

    public String getDateFinished() {
        return mDateFinished;
    }

    public void setDateFinished(String dateFinished) {
        mDateFinished = dateFinished;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mChallenger, i);
        parcel.writeParcelable(mChallengerBattlefield, i);
        parcel.writeParcelable(mChallengee, i);
        parcel.writeParcelable(mChallengeeBattlefield, i);
        parcel.writeParcelable(mNextTurn, i);
        parcel.writeInt(mTotalTurns);
        parcel.writeString(mDateStarted);
        parcel.writeString(mDateFinished);
    }

    @Override
    public void toJson() {

    }

    @Override
    public void fromJson() {

    }
}
