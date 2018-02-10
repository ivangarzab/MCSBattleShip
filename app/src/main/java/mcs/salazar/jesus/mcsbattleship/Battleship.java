package mcs.salazar.jesus.mcsbattleship.Models;

import android.os.Parcel;
import android.os.Parcelable;

import mcs.salazar.jesus.mcsbattleship.Model;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battleship extends Model implements Parcelable {

    private int mSize;
    private int mHitpoints;
    /** I bet there's a better way to do this... */
    //private ArrayList<int[][]> mCoordinates;
    private boolean mSunk;

    public Battleship() {
        mSize = -1;
        mHitpoints = -1;
        mSunk = false;
    }

    public Battleship(int size) {
        mSize = size;
        mHitpoints = mSize;
       // mCoordinates = new ArrayList<>(mSize);
        mSunk = false;
    }

    protected Battleship(Parcel in) {
        mSize = in.readInt();
        mHitpoints = in.readInt();
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

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public int getHitpoints() {
        return mHitpoints;
    }

    public void setHitpoints(int hitpoints) {
        mHitpoints = hitpoints;
    }

    /*public ArrayList<int[][]> getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(ArrayList<int[][]> coordinates) {
        mCoordinates = coordinates;
    }
*/
    public boolean isSunk() {
        return mSunk;
    }

    public void setSunk(boolean sunk) {
        mSunk = sunk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        parcel.writeInt(mHitpoints);
        parcel.writeByte((byte) (mSunk ? 1 : 0));
    }
}
