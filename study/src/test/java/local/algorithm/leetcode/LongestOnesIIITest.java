package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestOnesIIITest {

    @Test
    public void testLongestOnes1() {
        int result = new LongestOnesIII().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        assertEquals(result, 6);
    }

    @Test
    public void testLongestOnes2() {
        int result = new LongestOnesIII().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        assertEquals(result, 10);
    }

    @Test
    public void testLongestOnes3() {
        int result = new LongestOnesIII().longestOnes(new int[]{1, 1, 1, 0, 0, 1, 1}, 0);
        assertEquals(result, 3);
    }
}