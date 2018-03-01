package mcs.salazar.jesus.mcsbattleship;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import mcs.salazar.jesus.mcsbattleship.model.Coordinate;
import mcs.salazar.jesus.mcsbattleship.util.Util;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 2/10/2018
 */
public class BattleshipSetupTest {

    private final boolean[][] mGrid = {{false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}};

    @Test
    public void testAdjacentAvailableCoordinates() {
        // All cells are available
        int check0 = new Util().adjacentAvailableCoordinates(new Coordinate(2,2), mGrid).size();
        // All cells available + 1 obstruction
        boolean[][] grid1 = {{false, false, false, false, false},
                            {false, false, true, false, false},
                            {false, false, false, false, false},
                            {false, false, false, false, false},
                            {false, false, false, false, false}};
        int check1 = new Util().adjacentAvailableCoordinates(new Coordinate(2,2), grid1).size();
        // All cells available + 2 obstructions
        grid1[3][2] = true;
        int check2 = new Util().adjacentAvailableCoordinates(new Coordinate(2,2), grid1).size();
        // All cells available + 3 obstructions
        grid1[2][1] = true;
        int check3 = new Util().adjacentAvailableCoordinates(new Coordinate(2,2), grid1).size();
        // All cells available + 4 obstructions
        grid1[2][3] = true;
        int check4 = new Util().adjacentAvailableCoordinates(new Coordinate(2,2), grid1).size();
        // Corner case
        int check5 = new Util().adjacentAvailableCoordinates(new Coordinate(0,0), mGrid).size();
        // Corner case + 1 obstruction
        boolean[][] grid6 = {{false, false, false, false, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        int check6 = new Util().adjacentAvailableCoordinates(new Coordinate(0,0), grid6).size();
        // Corner case + 2 obstructions
        grid6[0][1] = true;
        int check7 = new Util().adjacentAvailableCoordinates(new Coordinate(0,0), grid6).size();
        // Side case
        int check8 = new Util().adjacentAvailableCoordinates(new Coordinate(2,4), mGrid).size();
        // Side case + 1 obstruction
        boolean[][] grid9 = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, false, false, false}};
        int check9 = new Util().adjacentAvailableCoordinates(new Coordinate(2,4), grid9).size();
        // Side case + 2 obstructions
        grid9[4][3] = true;
        int check10 = new Util().adjacentAvailableCoordinates(new Coordinate(2,4), grid9).size();
        // Side case + 3 obstructions
        grid9[3][2] = true;
        int check11 = new Util().adjacentAvailableCoordinates(new Coordinate(2,4), grid9).size();

        assertEquals(4, check0);
        assertEquals(3, check1);
        assertEquals(2, check2);
        assertEquals(1, check3);
        assertEquals(0, check4);
        assertEquals(2, check5);
        assertEquals(1, check6);
        assertEquals(0, check7);
        assertEquals(3, check8);
        assertEquals(2, check9);
        assertEquals(1, check10);
        assertEquals(0, check11);
    }

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

    @Test
    public void integrationTest() {
        Random random = new Random();
        boolean[][] grid = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        Coordinate initPos = new Coordinate(random.nextInt(5), random.nextInt(5));

        List<Coordinate> coordinates = new Util().adjacentAvailableCoordinates(initPos, grid);
        boolean check = new Util().doesShipFit(initPos,
                coordinates.get(random.nextInt(coordinates.size())), grid,
                random.nextInt(3) + 2);

        assertNotNull(check);
    }
}