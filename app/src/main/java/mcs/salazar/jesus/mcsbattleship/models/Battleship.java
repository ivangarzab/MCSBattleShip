package mcs.salazar.jesus.mcsbattleship.models;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battleship extends BaseObservable implements Model, Parcelable {

    private int mShipSize;
    private Coordinate[] mCoordinates;
    private boolean[] mHitpoints;

    public Battleship(int shipSize) {
        mShipSize = shipSize;
        mCoordinates = new Coordinate[mShipSize];
        mHitpoints = new boolean[mShipSize];

    }

    protected Battleship(Parcel in) {
        mShipSize = in.readInt();
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

    public int getShipSize() {
        return mShipSize;
    }

    public void setShipSize(int shipSize) {
        mShipSize = shipSize;
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
        parcel.writeInt(mShipSize);
        parcel.writeTypedArray(mCoordinates, i);
        parcel.writeBooleanArray(mHitpoints);
    }
}
