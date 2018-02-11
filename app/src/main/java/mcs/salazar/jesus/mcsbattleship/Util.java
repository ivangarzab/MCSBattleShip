package mcs.salazar.jesus.mcsbattleship;

import java.util.List;

import mcs.salazar.jesus.mcsbattleship.models.Battlefield;
import mcs.salazar.jesus.mcsbattleship.models.Battleship;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/8/2018
 */
public class Util {

    public static final char SHIP_IS_HIT = 'O';
    public static final char SHIP_MISSED = 'M';

    // Check if a coordinate hit a ship
    public boolean didItHit(Coordinate coordinate, List<Battleship> battleships) {
        boolean isHit = false;

        for (Battleship battleship: battleships) {

            for (Coordinate c : battleship.getCoordinates()) {
                if (c == coordinate) {
                    isHit = true;
                    return true;
                }
            }
        }
        final char hitGrid = isHit ? SHIP_IS_HIT : SHIP_MISSED;
        updateHitGrid(coordinate, hitGrid);
        return false;
    }

    private void updateHitGrid(Coordinate coordinate, final char grid) {
       char[][] hitGrid= null;
       int x = coordinate.getX() -1;
       int y = coordinate.getY()-1;
       hitGrid[y][x] = grid;
    }

    /**
     * Check whether the Battleship has any Hitpoints left
     * @param ship Battleship to inspect
     * @return true if Battleship has no Hitpoints left
     */
    public boolean didItSank(Battleship ship) {
        int hitpointsLeft = ship.getSize();
        for (boolean hit : ship.getHitpoints()) {
            if (hit) hitpointsLeft--;
        }
        return hitpointsLeft == 0;
    }

    /**
     * Check if the Coordinate on the grid has already been shot on
     * @param grid to check Coordinate
     * @param selection Coordinate selected by the User
     * @return Whether the Coordinate selected has already been shot
     */
    public boolean isNewCoordinateForSoot(boolean[][] grid, Coordinate selection) {
        if (grid[selection.getY()][selection.getX()]) return false;
        else {
            // Change grid's (Coordinate) tile boolean
            grid[selection.getY()][selection.getX()] = true;
            return false;
        }
    }

}
