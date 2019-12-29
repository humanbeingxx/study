package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:40
 */
public class NumEquivDominoPairsTest {

    @Test
    public void testNumEquivDominoPairs() {
        int result = new NumEquivDominoPairs().numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 2}, {2, 1}});
        assertEquals(result, 6);

        result = new NumEquivDominoPairs().numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}});
        assertEquals(result, 1);
    }
}