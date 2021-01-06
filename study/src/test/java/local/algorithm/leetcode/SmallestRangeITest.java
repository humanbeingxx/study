package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/4 14:54
 */
public class SmallestRangeITest {

    @Test
    public void testSmallestRangeI() {
        int result = new SmallestRangeI().smallestRangeI(new int[]{1, 3, 6}, 3);
        assertEquals(result, 0);
    }
}