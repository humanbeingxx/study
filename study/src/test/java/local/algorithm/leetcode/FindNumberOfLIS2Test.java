package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FindNumberOfLIS2Test {

    @Test
    public void testFindNumberOfLIS1() {
        int result = new FindNumberOfLIS2().findNumberOfLIS(new int[]{1, 1, 1, 1, 1});
        assertEquals(result, 5);
    }

    @Test
    public void testFindNumberOfLIS2() {
        int result = new FindNumberOfLIS2().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        assertEquals(result, 2);
    }

    @Test
    public void testFindNumberOfLIS5() {
        int result = new FindNumberOfLIS2().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7});
        assertEquals(result, 3);
    }

    @Test
    public void testFindNumberOfLIS6() {
        int result = new FindNumberOfLIS2().findNumberOfLIS(new int[]{2, 1});
        assertEquals(result, 2);
    }

    @Test
    public void testFindNumberOfLIS4() {
        int result = new FindNumberOfLIS2().findNumberOfLIS(new int[]{3, 1, 2});
        assertEquals(result, 1);
    }
}