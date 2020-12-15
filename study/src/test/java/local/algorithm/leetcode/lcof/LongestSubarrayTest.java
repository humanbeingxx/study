package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 16:07
 */
public class LongestSubarrayTest {

    @Test
    public void testLongestSubarray1() {
        int result = new LongestSubarray().longestSubarray(new int[]{8, 2, 4, 7}, 4);
        assertEquals(result, 2);
    }

    @Test
    public void testLongestSubarray2() {
        int result = new LongestSubarray().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
        assertEquals(result, 4);
    }

    @Test
    public void testLongestSubarray3() {
        int result = new LongestSubarray().longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0);
        assertEquals(result, 3);
    }
}