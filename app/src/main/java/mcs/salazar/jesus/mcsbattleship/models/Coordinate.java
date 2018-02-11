package mcs.salazar.jesus.mcsbattleship.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivan on 2/8/2018
 */
public class Coordinate implements Model, Parcelable {
    private int mX;
    private int mY;

    public Coordinate(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    protected Coordinate(Parcel in) {
        mX = in.readInt();
        mY = in.readInt();
    }

    public static final Creator<Coordinate> CREATOR = new Creator<Coordinate>() {
        @Override
        public Coordinate createFromParcel(Parcel in) {
            return new Coordinate(in);
        }

        @Override
        public Coordinate[] newArray(int size) {
            return new Coordinate[size];
        }
    };

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
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
        parcel.writeInt(mX);
        parcel.writeInt(mY);
    }
}
