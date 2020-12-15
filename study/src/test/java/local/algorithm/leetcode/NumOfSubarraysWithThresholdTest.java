package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumOfSubarraysWithThresholdTest {

    @Test
    public void testNumOfSubarrays1() {
        int result = new NumOfSubarraysWithThreshold().numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
        assertEquals(result, 3);
    }

    @Test
    public void testNumOfSubarrays2() {
        int result = new NumOfSubarraysWithThreshold().numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
        assertEquals(result, 6);
    }
}