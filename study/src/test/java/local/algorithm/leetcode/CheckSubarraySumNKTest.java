package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckSubarraySumNKTest {

    @Test
    public void testCheckSubarraySum1() {
        boolean result = new CheckSubarraySumNK().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
        assertTrue(result);
    }

    @Test
    public void testCheckSubarraySum2() {
        boolean result = new CheckSubarraySumNK().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6);
        assertTrue(result);
    }
}