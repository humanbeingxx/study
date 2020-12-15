package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class RotateArrayTest {

    @Test
    public void testRotateByForce() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotateByForce(data, 3);
        assertEquals(data, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    public void testRotate1() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray().rotate(data, 2);
        assertEquals(data, new int[]{7, 8, 1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testRotate2() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray().rotate(data, 3);
        assertEquals(data, new int[]{6, 7, 8, 1, 2, 3, 4, 5});
    }

    @Test
    public void testRotate3() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray().rotate(data, 3);
        assertEquals(data, new int[]{6, 7, 8, 1, 2, 3, 4, 5});
    }

    @Test
    public void testRotate4() {
        int[] data = {1, 2, 3, 4, 5, 6};
        new RotateArray().rotate(data, 4);
        assertEquals(data, new int[]{3, 4, 5, 6, 1, 2});
    }
}