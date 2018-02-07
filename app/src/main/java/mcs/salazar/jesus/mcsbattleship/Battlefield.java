package mcs.salazar.jesus.mcsbattleship;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battlefield extends Model implements Parcelable {

    private int mSize;
    /** This needs to be Parcel'd as well */
    //private boolean[][] mHitMatrix;
    private int mNumberOfShips;
    //private List<Battleship> mBattleships;
    private int mNumberOfShipsLeft;

    public Battlefield(int size, int numberOfShips) {
        mSize = size;
       // mHitMatrix = new boolean[mSize][mSize];
        mNumberOfShips = numberOfShips;
        //mBattleships = new ArrayList<>(mNumberOfShips);
        mNumberOfShipsLeft = mNumberOfShips;
    }

    protected Battlefield(Parcel in) {
        mSize = in.readInt();
        mNumberOfShips = in.readInt();
        //mBattleships = in.createTypedArrayList(Battleship.CREATOR);
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

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    /*public boolean[][] getHitMatrix() {
        return mHitMatrix;
    }

    public void setHitMatrix(boolean[][] hitMatrix) {
        mHitMatrix = hitMatrix;
    }
*/
    public int getNumberOfShips() {
        return mNumberOfShips;
    }

    public void setNumberOfShips(int numberOfShips) {
        mNumberOfShips = numberOfShips;
    }

  /*  public List<Battleship> getBattleships() {
        return mBattleships;
    }

    public void setBattleships(List<Battleship> battleships) {
        mBattleships = battleships;
    }
*/
    public int getNumberOfShipsLeft() {
        return mNumberOfShipsLeft;
    }

    public void setNumberOfShipsLeft(int numberOfShipsLeft) {
        mNumberOfShipsLeft = numberOfShipsLeft;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSize);
        parcel.writeInt(mNumberOfShips);
        //parcel.writeTypedList(mBattleships);
        parcel.writeInt(mNumberOfShipsLeft);
    }
}
