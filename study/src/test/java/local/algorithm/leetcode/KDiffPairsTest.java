package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KDiffPairsTest {

    @Test
    public void testFindPairs1() {
        int result = new KDiffPairs().findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        assertEquals(result, 2);
    }

    @Test
    public void testFindPairs2() {
        int result = new KDiffPairs().findPairs(new int[]{1, 2, 3, 4, 5}, 1);
        assertEquals(result, 4);
    }

    @Test
    public void testFindPairs3() {
        int result = new KDiffPairs().findPairs(new int[]{1, 3, 1, 5, 4}, 0);
        assertEquals(result, 1);
    }

    @Test
    public void testFindPairs5() {
        int result = new KDiffPairs().findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3);
        assertEquals(result, 2);
    }

    @Test
    public void testFindPairs6() {
        int result = new KDiffPairs().findPairs(new int[]{-1, -2, -3}, 1);
        assertEquals(result, 2);
    }
}