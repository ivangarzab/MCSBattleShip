package mcs.salazar.jesus.mcsbattleship;

import android.os.Parcel;
import android.os.Parcelable;

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
