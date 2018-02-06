package mcs.salazar.jesus.mcsbattleship;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battleship extends Model implements Parcelable {

    private int mSize;
    private boolean[] mHitpoints;
    /** I bet there's a better way to do this... */
    private ArrayList<int[][]> mCoordinates;
    private boolean mSunk;

    public Battleship(int size) {
        mSize = size;
        mHitpoints = new boolean[mSize];
        mCoordinates = new ArrayList<>(mSize);
        mSunk = false;
    }

    protected Battleship(Parcel in) {
        mSize = in.readInt();
        mHitpoints = in.createBooleanArray();
        mSunk = in.readByte() != 0;
    }

    public static final Creator<Battleship> CREATOR = new Creator<Battleship>() {
        @Override
        public Battleship createFromParcel(Parcel in) {
            return new Battleship(in);
        }

        @Override
        public Battleship[] newArray(int size) {
            return new Battleship[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        parcel.writeBooleanArray(mHitpoints);
        parcel.writeByte((byte) (mSunk ? 1 : 0));
    }
}
