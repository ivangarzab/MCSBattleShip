package mcs.salazar.jesus.mcsbattleship;

import org.junit.Test;

import mcs.salazar.jesus.mcsbattleship.models.Battleship;

import static org.junit.Assert.*;

/**
 * Created by Ivan on 2/11/2018
 */

public class InGamePostGameTest {

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
}
