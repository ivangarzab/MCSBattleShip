package mcs.salazar.jesus.mcsbattleship.Models;

import android.os.Parcel;
import android.os.Parcelable;

import mcs.salazar.jesus.mcsbattleship.Model;

/**
 * Created by Ivan on 2/5/2018
 */
public class User extends Model implements Parcelable {

    private String mId;
    private String mEmail;
    private int mScore;
    private int mGamesPlayed;
    private int mGamesWin;
    private int mGamesSurrender;
    private int mTotalHitsSent;
    private int mTotalHitsReceived;

    public User() {
        mId = "";
        mEmail = "";
        mScore = -1;
        mGamesPlayed = -1;
        mGamesWin = -1;
        mGamesSurrender = -1;
        mTotalHitsSent = -1;
        mTotalHitsReceived = -1;
    }

    protected User(Parcel in) {
        mId = in.readString();
        mEmail = in.readString();
        mScore = in.readInt();
        mGamesPlayed = in.readInt();
        mGamesWin = in.readInt();
        mGamesSurrender = in.readInt();
        mTotalHitsSent = in.readInt();
        mTotalHitsReceived = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public int getGamesPlayed() {
        return mGamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        mGamesPlayed = gamesPlayed;
    }

    public int getGamesWin() {
        return mGamesWin;
    }

    public void setGamesWin(int gamesWin) {
        mGamesWin = gamesWin;
    }

    public int getGamesSurrender() {
        return mGamesSurrender;
    }

    public void setGamesSurrender(int gamesSurrender) {
        mGamesSurrender = gamesSurrender;
    }

    public int getTotalHitsSent() {
        return mTotalHitsSent;
    }

    public void setTotalHitsSent(int totalHitsSent) {
        mTotalHitsSent = totalHitsSent;
    }

    public int getTotalHitsReceived() {
        return mTotalHitsReceived;
    }

    public void setTotalHitsReceived(int totalHitsReceived) {
        mTotalHitsReceived = totalHitsReceived;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mId);
        parcel.writeString(mEmail);
        parcel.writeInt(mScore);
        parcel.writeInt(mGamesPlayed);
        parcel.writeInt(mGamesWin);
        parcel.writeInt(mGamesSurrender);
        parcel.writeInt(mTotalHitsSent);
        parcel.writeInt(mTotalHitsReceived);
    }
}
