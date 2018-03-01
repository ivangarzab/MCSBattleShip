package mcs.salazar.jesus.mcsbattleship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import mcs.salazar.jesus.mcsbattleship.model.Battleship;
import mcs.salazar.jesus.mcsbattleship.model.Coordinate;
import mcs.salazar.jesus.mcsbattleship.util.Util;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by berekethaile on 2/10/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class mockitoDidItHit {

    Util mUtil = Mockito.mock(Util.class);

    @Test
    public void didItHit_battlship() {


        Coordinate[] shipGrid= new Coordinate[]{new Coordinate(0, 0), new Coordinate(0, 1)};
        Battleship battleship= new Battleship(2);
        List<Battleship> battleships= new ArrayList<>();
        battleship.setCoordinates(shipGrid);
        battleships.add(battleship);
        Coordinate coordinate = new Coordinate(0,0);
        when (mUtil.didItHit(coordinate, battleships)).thenReturn(Boolean.valueOf("Util"));

        assertThat(mUtil.didItHit(coordinate, battleships), is(true));
    }

    @Test
    public void isNewCoordinateForShoot() {
      //  int[][] matrix = new int[][]{false, true, true, false}
    }
}
