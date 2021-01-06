package local.algorithm.leetcode.lcof;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/13 17:16
 */
public class PresentValueTest {

    @Test
    public void testMaxValue() {
        int result = new PresentValue().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        assertEquals(result, 12);
    }
}