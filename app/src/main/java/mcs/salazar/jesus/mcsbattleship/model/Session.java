package mcs.salazar.jesus.mcsbattleship.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Ivan on 2/5/2018
 */
@IgnoreExtraProperties
public class Session implements Model, Parcelable {

    private final static int BATTLEFIELD_SIZE = 8;
    private final static int BATTLESHIPS_PER_PLAYER = 4;

    private User mPlayer;
    private Battlefield mPlayerBattlefield;
    private User mOpponent;
    private Battlefield mOpponentBattlefield;
    private User mNextTurn;
    private int mTotalTurns;
    private String mDateStarted;
    private String mDateFinished;

    public Session() {
        this.mPlayer = new User();
        this.mPlayerBattlefield = new Battlefield();
        this.mOpponent = new User();
        this.mOpponentBattlefield = new Battlefield();
        this.mNextTurn = null;
        this.mTotalTurns = 0;
        mDateStarted = "";
        mDateFinished = "";
    };

    public Session(User opponent, User player) {
        mPlayer = player;
        mPlayerBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mOpponent = opponent;
        mOpponentBattlefield = new Battlefield(BATTLEFIELD_SIZE, BATTLESHIPS_PER_PLAYER);
        mNextTurn = mPlayer;
        mTotalTurns = 0;
        // Get today's date
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        mDateStarted = df.format(c.getTime());
        mDateFinished = "";
    }

    protected Session(Parcel in) {
        mPlayer = in.readParcelable(User.class.getClassLoader());
        mPlayerBattlefield = in.readParcelable(Battlefield.class.getClassLoader());
        mNextTurn = in.readParcelable(User.class.getClassLoader());
        mOpponent = in.readParcelable(User.class.getClassLoader());
        mOpponentBattlefield = in.readParcelable(Battlefield.class.getClassLoader());
        mTotalTurns = in.readInt();
        mDateStarted = in.readString();
        mDateFinished = in.readString();
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String , Object> result = new HashMap<>();
        result.put("opponent", mOpponent);
        result.put("player", mPlayer);
        return result;
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

    public User getPlayer() {
        return mPlayer;
    }

    public void setPlayer(User player) {
        mPlayer = player;
    }

    public Battlefield getPlayerBattlefield() {
        return mPlayerBattlefield;
    }

    public void setPlayerBattlefield(Battlefield playerBattlefield) {
        mPlayerBattlefield = playerBattlefield;
    }

    public User getOpponent() {
        return mOpponent;
    }

    public void setOpponent(User opponent) {
        mOpponent = opponent;
    }

    public Battlefield getOpponentBattlefield() {
        return mOpponentBattlefield;
    }

    public void setOpponentBattlefield(Battlefield opponentBattlefield) {
        mOpponentBattlefield = opponentBattlefield;
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
        parcel.writeParcelable(mPlayerBattlefield, i);
        parcel.writeParcelable(mNextTurn, i);
        parcel.writeParcelable(mOpponent, i);
        parcel.writeParcelable(mOpponentBattlefield, i);
        parcel.writeParcelable(mPlayer, i);
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
