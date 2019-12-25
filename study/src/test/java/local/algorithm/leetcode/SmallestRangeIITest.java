package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class SmallestRangeIITest {

    @Test
    public void testSmallestRangeII() {
        int result = new SmallestRangeII().smallestRangeII(new int[]{1, 3, 6}, 3);
        assertEquals(result, 3);

    }
}