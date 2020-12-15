package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThreeConsecutiveOddsTest {

    @Test
    public void testThreeConsecutiveOdds() {
        assertTrue(new ThreeConsecutiveOdds().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        assertFalse(new ThreeConsecutiveOdds().threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
    }
}