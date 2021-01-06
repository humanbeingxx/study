package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 13:49
 */
public class LargestSumAfterKNegationsTest {

    @Test
    public void testLargestSumAfterKNegations() {
        int result = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        assertEquals(result, 5);

        result = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        assertEquals(result, 6);

        result = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        assertEquals(result, 13);

        result = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3}, 10);
        assertEquals(result, 9);

        result = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6);
        assertEquals(result, 22);
    }
}