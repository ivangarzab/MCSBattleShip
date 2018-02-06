package mcs.salazar.jesus.mcsbattleship;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battlefield extends Model implements Parcelable {

    private int mSize;
    /** This needs to be Parcel'd as well */
    private boolean[][] mHitMatrix;
    private int mNumberOfShips;
    private Battleship[] mBattleships;
    private int mNumberOfShipsLeft;

    public Battlefield(int size, int numberOfShips) {
        mSize = size;
        mHitMatrix = new boolean[mSize][mSize];
        mNumberOfShips = numberOfShips;
        mBattleships = new Battleship[mNumberOfShips];
        mNumberOfShipsLeft = mNumberOfShips;
    }

    protected Battlefield(Parcel in) {
        mSize = in.readInt();
        mNumberOfShips = in.readInt();
        mBattleships = in.createTypedArray(Battleship.CREATOR);
        mNumberOfShipsLeft = in.readInt();
    }

    public static final Creator<Battlefield> CREATOR = new Creator<Battlefield>() {
        @Override
        public Battlefield createFromParcel(Parcel in) {
            return new Battlefield(in);
        }

        @Override
        public Battlefield[] newArray(int size) {
            return new Battlefield[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        parcel.writeInt(mNumberOfShips);
        parcel.writeTypedArray(mBattleships, i);
        parcel.writeInt(mNumberOfShipsLeft);
    }
}
