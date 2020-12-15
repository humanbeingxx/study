package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShipWithinDaysTest {

    @Test
    public void testShipWithinDays1() {
        int result = new ShipWithinDays().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        assertEquals(result, 15);
    }

    @Test
    public void testShipWithinDays2() {
        int result = new ShipWithinDays().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        assertEquals(result, 6);
    }

    @Test
    public void testShipWithinDays3() {
        int result = new ShipWithinDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
        assertEquals(result, 3);
    }
}