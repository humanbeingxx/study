package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumArray20210105Test {

    @Test
    public void testSumRange() {
        NumArray20210105 array = new NumArray20210105(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(array.sumRange(2, 5), 18);
        assertEquals(array.sumRange(0, 7), 36);
        assertEquals(array.sumRange(0, 0), 1);
        assertEquals(array.sumRange(7, 7), 8);

        array.update(3, 0);

        // 1, 2, 3, 0, 5, 6, 7, 8
        assertEquals(array.sumRange(2, 5), 14);
        assertEquals(array.sumRange(0, 7), 32);
        assertEquals(array.sumRange(0, 0), 1);
        assertEquals(array.sumRange(7, 7), 8);
    }
}