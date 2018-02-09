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
            if (!grid[coordinate.x - 1][coordinate.y])
                availableTiles.add(new Coordinate(coordinate.x - 1, coordinate.y));
        }
        if (!(coordinate.x + 1 >= BATTLEFIELD_SIZE)) {
            if (!grid[coordinate.x + 1][coordinate.y])
                availableTiles.add(new Coordinate(coordinate.x + 1, coordinate.y));
        }
        if (!(coordinate.y - 1 < 0)) {
            if (!grid[coordinate.x][coordinate.y - 1])
                availableTiles.add(new Coordinate(coordinate.x, coordinate.y - 1));
        }
        if (!(coordinate.y + 1 >= BATTLEFIELD_SIZE)) {
            if (!grid[coordinate.x][coordinate.y + 1])
                availableTiles.add(new Coordinate(coordinate.x, coordinate.y + 1));
        }
        Log.i("TRASH", "Available Tiles: " + availableTiles.size());
        return availableTiles;
    }


}
