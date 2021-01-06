package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestWPITest {

    @Test
    public void testLongestWPI1() {
        int result = new LongestWPI().longestWPI(new int[]{9, 9, 6, 0, 9, 9, 9, 9, 6, 6, 9});
        assertEquals(result, 11);
    }

    @Test
    public void testLongestWPI2() {
        int result = new LongestWPI().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9});
        assertEquals(result, 3);
    }

    @Test
    public void testLongestWPI3() {
        int result = new LongestWPI().longestWPI(new int[]{9, 9, 6, 0, 0, 0, 0, 9, 9, 6, 0, 9});
        assertEquals(result, 5);
    }

    @Test
    public void testLongestWPI4() {
        int result = new LongestWPI().longestWPI(new int[]{6, 6, 9, 9, 6, 9, 9});
        assertEquals(result, 7);
    }
}