package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/17 0:58
 */
public class MaxAreaTest {

    @Test
    public void testMaxArea() {
        int result = new MaxArea().maxArea(new int[]{1, 8, 6, 100, 100, 4, 8, 3, 7, 3});
        assertEquals(result, 100);
    }
}