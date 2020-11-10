package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RotateArray2Test {
    @Test
    public void testRotate1() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray2().rotate(data, 2);
        assertEquals(data, new int[]{7, 8, 1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testRotate2() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray2().rotate(data, 3);
        assertEquals(data, new int[]{6, 7, 8, 1, 2, 3, 4, 5});
    }

    @Test
    public void testRotate3() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray2().rotate(data, 3);
        assertEquals(data, new int[]{6, 7, 8, 1, 2, 3, 4, 5});
    }
}