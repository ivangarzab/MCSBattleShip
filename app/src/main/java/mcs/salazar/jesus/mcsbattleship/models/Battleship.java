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
    private Coordinate[] mCoordinates;
    private boolean[] mHitpoints;

    public Battleship(int size) {
        mSize = size;
        mCoordinates = new Coordinate[mSize];
        mHitpoints = new boolean[mSize];

    }

    protected Battleship(Parcel in) {
        mSize = in.readInt();
        mCoordinates = in.createTypedArray(Coordinate.CREATOR);
        mHitpoints = in.createBooleanArray();
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

    public Coordinate[] getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        mCoordinates = coordinates;
    }

    public boolean[] getHitpoints() {
        return mHitpoints;
    }

    public void setHitpoints(boolean[] hitpoints) {
        mHitpoints = hitpoints;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        parcel.writeTypedArray(mCoordinates, i);
        parcel.writeBooleanArray(mHitpoints);
    }
}
