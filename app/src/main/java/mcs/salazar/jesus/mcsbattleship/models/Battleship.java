package mcs.salazar.jesus.mcsbattleship.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battleship implements Model, Parcelable {

    private int mSize;
    private int mHitpoints;
    private Coordinate[] mCoordinates;
    private boolean mSunk;
    int[] array;

    public Battleship(int size) {
        mSize = size;
        mHitpoints = mSize;
        mCoordinates = new Coordinate[mSize];
        mSunk = false;
    }

    protected Battleship(Parcel in) {
        mSize = in.readInt();
        mHitpoints = in.readInt();
        mSunk = in.readByte() != 0;
        array = new int[in.readInt()];
        in.readIntArray(array);
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
    public void toJson() {

    }

    @Override
    public void fromJson() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSize);
        dest.writeInt(mHitpoints);
        dest.writeByte((byte) (mSunk ? 1 : 0));
        dest.writeInt(mCoordinates.length);
        dest.writeIntArray(array);
    }

    public Coordinate[] getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        mCoordinates = coordinates;
    }
}
