package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class SumPivotIndexTest {

    @Test
    public void testPivotIndex() {
        int result = new SumPivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        assertEquals(result, 3);

        result = new SumPivotIndex().pivotIndex(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, -1);

        result = new SumPivotIndex().pivotIndex(new int[]{1, 2, 3, 4, -10});
        assertEquals(result, -1);

        result = new SumPivotIndex().pivotIndex(new int[]{1, 2, 3, 4, -10, 10000});
        assertEquals(result, 5);
    }
}