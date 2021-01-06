package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CarFleetTest {

    @Test
    public void testCarFleet1() {
        int fleet = new CarFleet().carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
        assertEquals(fleet, 3);
    }
}