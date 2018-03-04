package mcs.salazar.jesus.mcsbattleship.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battlefield implements Model, Parcelable {

    private int mSize;
    private boolean[][] mGrid;
    private int mNumberOfShips;
    private Battleship[] mBattleships;
    private int mNumberOfShipsLeft;

    public Battlefield() {
        /*this.mSize = 0;
        this.mGrid = null;
        this.mNumberOfShips = 0;
        this.mBattleships =  new Battleship[0];
        this.mNumberOfShipsLeft = -1;*/
    }

    public Battlefield(int size, int numberOfShips) {
        mSize = size;
        mNumberOfShips = numberOfShips;
        //mBattleships = new Battleship[mNumberOfShips];
        mNumberOfShipsLeft = mNumberOfShips;
        // Initiate and populate grid
        mGrid = new boolean[mSize][mSize];
    }


    protected Battlefield(Parcel in) {
        mSize = in.readInt();
        mGrid = (boolean[][])in.readSerializable();
        mNumberOfShips = in.readInt();
        //mBattleships = in.createTypedArray(Battleship.CREATOR);
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

    public boolean[][] getGrid() {
        return mGrid;
    }

    public void setGrid(boolean[][] grid) {
        mGrid = grid;
    }

    public int getNumberOfShips() {
        return mNumberOfShips;
    }

    public void setNumberOfShips(int numberOfShips) {
        mNumberOfShips = numberOfShips;
    }

    public Battleship[] getBattleships() {
        return mBattleships;
    }

    public void setBattleships(Battleship[] battleships) {
        mBattleships = battleships;
    }

    public int getNumberOfShipsLeft() {
        return mNumberOfShipsLeft;
    }

    public void setNumberOfShipsLeft(int numberOfShipsLeft) {
        mNumberOfShipsLeft = numberOfShipsLeft;
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
        parcel.writeSerializable(mGrid);
        parcel.writeInt(mNumberOfShips);
       // parcel.writeTypedArray(mBattleships, i);
        parcel.writeInt(mNumberOfShipsLeft);
    }
}
