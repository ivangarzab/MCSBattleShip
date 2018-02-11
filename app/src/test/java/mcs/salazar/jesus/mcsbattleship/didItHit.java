package mcs.salazar.jesus.mcsbattleship;

import android.text.Spanned;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import mcs.salazar.jesus.mcsbattleship.models.Battleship;
import mcs.salazar.jesus.mcsbattleship.models.Coordinate;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by berekethaile on 2/10/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class didItHit {

    Util mUtil = Mockito.mock(Util.class);

    @Test
    public void didItHit_battlship() {

        List<Battleship> battleships=null;

        Coordinate coordinate = null;
        Coordinate [] coordinate1= null;
        Util util = Mockito.mock(Util.class);
        Battleship battleship= null;
        battleship.setSize(1);
        coordinate.setX(2);
        coordinate.setY(1);

        battleship.setCoordinates(coordinate1);

        battleship.setCoordinates(coordinate1);
        battleships.add(battleship);

        int x = 2;
        int y = 1;
        coordinate.setX(1);
        coordinate.setY(2);
        when (util.didItHit(coordinate, battleships)).thenReturn(Boolean.valueOf("Util"));

        //assertThat(util.didItHit(), hitShip.length());
    }
}
