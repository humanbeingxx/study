package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:24
 */
public class SumEvenAfterQueriesTest {

    @Test
    public void testSumEvenAfterQueries() {
        int[] result = new SumEvenAfterQueries().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});
        assertEquals(result, new int[]{8, 6, 2, 4});
    }
}