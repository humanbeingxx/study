package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxSumDivThreeTest {

    @Test
    public void testMaxSumDivThree1() {
        int result = new MaxSumDivThree().maxSumDivThree(new int[]{3,6,5,1,8});
        assertEquals(result, 18);
    }

    @Test
    public void testMaxSumDivThree2() {
        int result = new MaxSumDivThree().maxSumDivThree(new int[]{1,2,3,4,4});
        assertEquals(result, 12);
    }
}