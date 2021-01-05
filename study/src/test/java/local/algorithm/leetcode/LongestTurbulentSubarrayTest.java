package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestTurbulentSubarrayTest {

    @Test
    public void testMaxTurbulenceSize1() {
        int result = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        assertEquals(result, 5);
    }

    @Test
    public void testMaxTurbulenceSize2() {
        int result = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{4, 8, 12, 16});
        assertEquals(result, 2);
    }

    @Test
    public void testMaxTurbulenceSize3() {
        int result = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{1,2,1,2,1,2,1,2,1,2});
        assertEquals(result, 10);
    }

    @Test
    public void testMaxTurbulenceSize4() {
        int result = new LongestTurbulentSubarray().maxTurbulenceSize(new int[]{1,1,1,1,1,2,2,2});
        assertEquals(result, 2);
    }
}