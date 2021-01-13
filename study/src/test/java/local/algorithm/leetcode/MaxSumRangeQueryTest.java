package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxSumRangeQueryTest {

    @Test
    public void testMaxSumRangeQuery1() {
        int result = new MaxSumRangeQuery().maxSumRangeQuery(new int[]{1,2,3,4,5},
                new int[][]{{1,3}, {0,1}});
        assertEquals(result, 19);
    }
}