package mcs.salazar.jesus.mcsbattleship;

import java.util.List;

import mcs.salazar.jesus.mcsbattleship.models.Battlefield;
import mcs.salazar.jesus.mcsbattleship.models.Battleship;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/8/2018
 */
public class Util {


    // Check if a coordinate hit a ship
    public boolean didItHit(Coordinate coordinate, List<Battleship> battleships) {

        for (Battleship battleship : battleships) {

            for (Coordinate c : battleship.getCoordinates()) {
                if (c.getX() == coordinate.getX() && c.getY() == coordinate.getY()) {
                    return true;
                }
            }
        }

        return false;
    }

   /* private void updateHitGrid(Coordinate coordinate, Battleship battleship, boolean hitGrid) {
        for (boolean hit : battleship.getHitpoints()) {
            if (coordinate.getX() == coordinate.getX() && coordinate.getY() == coordinate.getY()) {
                hit = hitGrid;
            }
        }

    }*/

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
    public boolean isNewCoordinateForShoot(boolean[][] grid, Coordinate selection) {
        if (grid[selection.getY()][selection.getX()]) return false;
        else {
            // Change grid's (Coordinate) tile boolean
            grid[selection.getY()][selection.getX()] = true;
            return true;
        }
    }

}
