package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxErasureValueTest {

    @Test
    public void testMaximumUniqueSubarray1() {
        int result = new MaxErasureValue().maximumUniqueSubarray(new int[]{4,2,4,5,6});
        assertEquals(result, 17);
    }

    @Test
    public void testMaximumUniqueSubarray2() {
        int result = new MaxErasureValue().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5});
        assertEquals(result, 8);
    }

    @Test
    public void testMaximumUniqueSubarray3() {
        int result = new MaxErasureValue().maximumUniqueSubarray(new int[]{1});
        assertEquals(result, 1);
    }
}