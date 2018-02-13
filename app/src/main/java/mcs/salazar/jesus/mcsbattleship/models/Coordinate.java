package mcs.salazar.jesus.mcsbattleship.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivan on 2/8/2018
 */
public class Coordinate implements Model {
    public  int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
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
