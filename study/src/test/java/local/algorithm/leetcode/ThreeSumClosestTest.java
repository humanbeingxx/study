package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThreeSumClosestTest {

    @Test
    public void testThreeSumClosest() {
        int result = new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        assertEquals(result, 2);
    }

    @Test
    public void testSumClosest() {
    }
}