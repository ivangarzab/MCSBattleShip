package mcs.salazar.jesus.mcsbattleship;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import mcs.salazar.jesus.mcsbattleship.models.Battleship;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 2/11/2018
 */

public class InGamePostGameTest {
    @Test
    public void testDidItHit() {

        Coordinate[] shipGrid= new Coordinate[]{new Coordinate(0, 0), new Coordinate(0, 1)};
        List<Battleship> battleships= new ArrayList<>();

        // Battleship size= 1
        Battleship battleship1= new Battleship(1);
        // Battleship size = 2
        Battleship battleship2= new Battleship(2);
        // Set coordinate for battleship size 1 and 2
        battleship1.setCoordinates(shipGrid);
        battleship2.setCoordinates(shipGrid);
        // Add the battleship to the list
        battleships.add(battleship1);
        battleships.add(battleship2);

        // Hit for coordinate (0,0)
        Coordinate coordinate1 = new Coordinate(0,0);
        boolean check1 = new Util().didItHit(coordinate1, battleships);
        // Not hit for coordinate (1,0)
        Coordinate coordinate2= new Coordinate(1,0);
        boolean check2 = new Util().didItHit(coordinate2, battleships);
        // Hit for coordinate (0,1)
        Coordinate coordinate3= new Coordinate(0,1);
        boolean check3 = new Util().didItHit(coordinate3, battleships);
        // Not hit for coordinate (1,0)
        Coordinate coordinate4= new Coordinate(1,0);
        boolean check4 = new Util().didItHit(coordinate4, battleships);

       assertTrue(check1);
       assertFalse(check2);
       assertTrue(check3);
       assertFalse(check4);

    }

    @Test
    public void testCheckGridForShoot() {
        boolean[][] board = new boolean [2][2];
        board[0][0] = false;
        board[0][1] = true;
        board[1][0] = true;
        board[1][1] = false;
        // Coordinate is shoot
        Coordinate coordinate1 = new Coordinate(0,1);
        boolean check5 = new Util().isNewCoordinateForShoot(board,coordinate1 );
        // Coordinate is not shoot
        Coordinate coordinate2 = new Coordinate(0,0);
        boolean check6 = new Util().isNewCoordinateForShoot(board,coordinate2 );

        assertFalse(check5);
        assertTrue(check6);
    }

    @Test
    public void testDidItSank() {

        Battleship ship1 = new Battleship(1);
        // Battleship size = 1 ; no hits
        boolean check11 = new Util().didItSank(ship1);
        // Battleship size = 1 ; 1 hit
        ship1.setHitpoints(new boolean[]{true});
        boolean check12 = new Util().didItSank(ship1);

        Battleship ship2 = new Battleship(2);
        // Battleship size = 2 ; no hits
        boolean check21 = new Util().didItSank(ship2);
        // Battleship size = 2 ; 1 hit
        ship2.setHitpoints(new boolean[]{true, false});
        boolean check22 = new Util().didItSank(ship2);
        // Battleship size = 2 ; 2 hits
        ship2.setHitpoints(new boolean[]{true, true});
        boolean check23 = new Util().didItSank(ship2);

        Battleship ship3 = new Battleship(3);
        // Battleship size = 3 ; no hits
        boolean check31 = new Util().didItSank(ship3);
        // Battleship size = 3 ; 1 hit
        ship3.setHitpoints(new boolean[]{true, false, false});
        boolean check32 = new Util().didItSank(ship3);
        // Battleship size = 3 ; 2 hits
        ship3.setHitpoints(new boolean[]{true, true, false});
        boolean check33 = new Util().didItSank(ship3);
        // Battleship size = 3 ; 3 hits
        ship3.setHitpoints(new boolean[]{true, true, true});
        boolean check34 = new Util().didItSank(ship3);

        assertFalse(check11);
        assertTrue(check12);

        assertFalse(check21);
        assertFalse(check22);
        assertTrue(check23);

        assertFalse(check31);
        assertFalse(check32);
        assertFalse(check33);
        assertTrue(check34);
    }

    @Test
    public void integrationTest(){
        boolean[][] board = new boolean [2][2];
        board[0][0] = false;
        board[0][1] = true;
        board[1][0] = true;
        board[1][1] = false;
        // Coordinate is shoot
        Coordinate coordinate1 = new Coordinate(0,1);

        Coordinate[] shipGrid= new Coordinate[]{new Coordinate(0, 0), new Coordinate(0, 1)};
        List<Battleship> battleships= new ArrayList<>();
        // Battleship size= 1
        Battleship battleship1= new Battleship(1);
        // Set coordinate for battleship size 1 and 2
        battleship1.setCoordinates(shipGrid);
        // Add the battleship to the list
        battleships.add(battleship1);
        battleship1.setHitpoints(new boolean[]{true});

        // Check if coordinate is shoot
        boolean check6 = new Util().isNewCoordinateForShoot(board,coordinate1 );
        // Check battleship is hit
        boolean check7 = new Util().didItHit(coordinate1, battleships);
        // Check if battleship sunk
        boolean check8 = new Util().didItSank(battleship1);

        assertFalse(check6);
        assertTrue(check7);
        assertTrue(check8);
    }
}
