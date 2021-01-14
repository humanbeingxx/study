package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WaysToSplitStringTest {

    @Test
    public void testNumWays1() {
        int result = new WaysToSplitString().numWays("10101");
        assertEquals(result, 4);
    }

    @Test
    public void testNumWays2() {
        int result = new WaysToSplitString().numWays("100100010100110");
        assertEquals(result, 12);
    }

    @Test
    public void testNumWays3() {
        int result = new WaysToSplitString().numWays("111");
        assertEquals(result, 1);
    }
}