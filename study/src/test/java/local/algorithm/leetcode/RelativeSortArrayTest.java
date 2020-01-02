package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class RelativeSortArrayTest {

    @Test
    public void testRelativeSortArray() {
        int[] result = new RelativeSortArray().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6});
        assertEquals(result, new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19});
    }
}