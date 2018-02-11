package mcs.salazar.jesus.mcsbattleship;

import org.junit.Test;

import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 2/10/2018
 */
public class BattleshipSetupTest {

    public  boolean[][] mGrid = {{false, false, false, false, false},
                                {false, false, false, false, false},
                                {false, false, false, false, false},
                                {false, false, false, false, false},
                                {false, false, false, false, false}};

    @Test
    public void testDoesShipFit() {
        // Default test where Battleship size = 2
        boolean check0 = new Util().doesShipFit(new Coordinate(0,0), new Coordinate(1,0),
                mGrid, 2);

        /* Tests for x */
        // Battleship size > 2 ; x+ ; no obstacles
        boolean check1 = new Util().doesShipFit(new Coordinate(0,0), new Coordinate(1,0),
                mGrid, 4);
        // Battleship size > 2 ; x+ ; no obstacles ; ship is too long
        boolean check2 = new Util().doesShipFit(new Coordinate(3,0), new Coordinate(4,0),
                mGrid, 4);
        // Battleship size > 2 ; x+ ; with obstacles
        boolean[][] grid3 = mGrid;
        grid3[0][2] = true;
        boolean check3 = new Util().doesShipFit(new Coordinate(0,0), new Coordinate(1,0),
                grid3, 4);
        // Battleship size > 2 ; x- ; no obstacles
        boolean check4 = new Util().doesShipFit(new Coordinate(4,4), new Coordinate(3,4),
                mGrid, 4);
        // Battleship size > 2 ; x- ; no obstacles ; ship is too long
        boolean check5 = new Util().doesShipFit(new Coordinate(1,4), new Coordinate(0,4),
                mGrid, 4);
        // Battleship size > 2 ; x- ; with obstacles
        boolean[][] grid6 = mGrid;
        grid6[4][2] = true;
        boolean check6 = new Util().doesShipFit(new Coordinate(4,4), new Coordinate(3,4),
                grid6, 4);

        /* Tests for y */
        // Battleship size > 2 ; y+ ; no obstacles
        boolean check7 = new Util().doesShipFit(new Coordinate(0,0), new Coordinate(0,1),
                mGrid, 4);
        // Battleship size > 2 ; y+ ; no obstacles ; ship is too long
        boolean check8 = new Util().doesShipFit(new Coordinate(0,3), new Coordinate(0,4),
                mGrid, 4);
        // Battleship size > 2 ; y+ ; with obstacles
        boolean[][] grid9 = mGrid;
        grid9[2][0] = true;
        boolean check9 = new Util().doesShipFit(new Coordinate(0,0), new Coordinate(0,1),
                grid9, 4);
        // Battleship size > 2 ; y- ; no obstacles
        boolean check10 = new Util().doesShipFit(new Coordinate(4,4), new Coordinate(4,3),
                mGrid, 4);
        // Battleship size > 2 ; y- ; no obstacles ; ship is too long
        boolean check11 = new Util().doesShipFit(new Coordinate(4,1), new Coordinate(4,0),
                mGrid, 4);
        // Battleship size > 2 ; y- ; with obstacles
        boolean[][] grid12 = mGrid;
        grid12[2][4] = true;
        boolean check12 = new Util().doesShipFit(new Coordinate(4,4), new Coordinate(4,3),
                grid12, 4);


        assertTrue(check0);
        assertTrue(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
        assertFalse(check5);
        assertFalse(check6);
        assertTrue(check7);
        assertFalse(check8);
        assertFalse(check9);
        assertTrue(check10);
        assertFalse(check11);
        assertFalse(check12);

    }
}