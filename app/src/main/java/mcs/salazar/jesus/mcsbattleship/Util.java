package mcs.salazar.jesus.mcsbattleship;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

/**
 * Created by Ivan on 2/8/2018
 */
public class Util {

    private static final int BATTLEFIELD_SIZE = 5;

    /**
     * Explore the tiles adjacent to the coordinate on the grid
     * @param coordinate Chosen coordinate on the grid
     * @param grid Grid representing battlefield
     * @return List containing the available tiles around coordinate
     */
    public List<Coordinate> adjacentAvailableCoordinates(Coordinate coordinate, boolean[][] grid) {
        List<Coordinate> availableTiles = new ArrayList<>();
        // Check for the availability of adjacent cells of coordinate
        if (!(coordinate.x - 1 < 0)) {
            // Left
            if (!grid[coordinate.y][coordinate.x - 1])
                availableTiles.add(new Coordinate(coordinate.x - 1, coordinate.y));
        }
        if (!(coordinate.x + 1 >= grid[0].length)) {
            // Right
            if (!grid[coordinate.y][coordinate.x + 1])
                availableTiles.add(new Coordinate(coordinate.x + 1, coordinate.y));
        }
        if (!(coordinate.y - 1 < 0)) {
            // Top
            if (!grid[coordinate.y - 1][coordinate.x])
                availableTiles.add(new Coordinate(coordinate.x, coordinate.y - 1));
        }
        if (!(coordinate.y + 1 >= grid.length)) {
            // Bottom
            if (!grid[coordinate.y + 1][coordinate.x])
                availableTiles.add(new Coordinate(coordinate.x, coordinate.y + 1));
        }
        return availableTiles;
    }

    /**
     * Explore the tiles that a ship of certain size want to occupy
     * @param position Initial position for the ship's front
     * @param direction Second position of ship which infers the direction
     * @param grid Grid representing battlefield
     * @param size Size of the give ship
     * @return Whether the Battleship of given size can fit the explored tiles
     */
    public boolean doesShipFit(Coordinate position, Coordinate direction,
                               boolean[][] grid, int size) {
        // If the ship size is 2 or less, return true before processing
        if (size <= 2) return true;

        boolean doesFit = true;
        // Figure out the orientation of the ship
        // Explore grid through x
        if (!(position.x == direction.x)) {
            if (position.x < direction.x) {
                for (int i = position.x; i < (position.x + size); i++) {
                    if (i >= grid[0].length) { return false; }
                    if (grid[direction.y][i]) { return false; }
                }
            }
            else { //position.x > direction.x
                for (int i = position.x; i > (position.x - size); i--) {
                    if (i < 0) { return false; }
                    if (grid[direction.y][i]) { return false; }
                }
            }
        }
        // Explore grid through y
        else if (!(position.y == direction.y)) {
            if (position.y < direction.y) {
                for (int i = position.y; i < (position.y + size); i++) {
                    if (i >= BATTLEFIELD_SIZE) {
                        doesFit = false;
                        break;
                    }
                    if (grid[i][direction.x]) {
                        doesFit = false;
                        break;
                    }
                }
            } else { //position.y > direction.y
                for (int i = position.y; i > (position.y - size); i--) {
                    if (i < 0) {
                        doesFit = false;
                        break;
                    }
                    if (grid[i][direction.x]) {
                        doesFit = false;
                        break;
                    }
                }
            }
        }
        return doesFit;
    }
}
