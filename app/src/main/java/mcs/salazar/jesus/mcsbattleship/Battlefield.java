package mcs.salazar.jesus.mcsbattleship;

/**
 * Created by Ivan on 2/5/2018
 */
public class Battlefield extends Model {

    private int mSize;
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
}
