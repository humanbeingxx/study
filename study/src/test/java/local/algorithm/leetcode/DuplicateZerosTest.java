package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class DuplicateZerosTest {

    @Test
    public void testCountAdd0() {
        int count = new DuplicateZeros().countAdd0(new int[]{1, 2, 3});
        assertEquals(count, 0);

        count = new DuplicateZeros().countAdd0(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        assertEquals(count, 2);

        count = new DuplicateZeros().countAdd0(new int[]{1, 0, 0, 0, 0, 4, 5, 4});
        assertEquals(count, 3);

        count = new DuplicateZeros().countAdd0(new int[]{1, 0, 0, 0, 0, 4, 5, 4, 1});
        assertEquals(count, 4);
    }

    @Test
    public void testDuplicateZeros1() {
        int[] data = {1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(data);
        assertEquals(data, new int[]{1, 0, 0, 2, 3, 0, 0, 4});
    }

    @Test
    public void testDuplicateZeros2() {
        int[] data = {1, 2, 3};
        new DuplicateZeros().duplicateZeros(data);
        assertEquals(data, new int[]{1, 2, 3});
    }

    @Test
    public void testDuplicateZeros3() {
        int[] data = {1, 0, 0, 0, 0, 4, 5, 4};
        new DuplicateZeros().duplicateZeros(data);
        assertEquals(data, new int[]{1, 0, 0, 0, 0, 0, 0, 0});
    }

    @Test
    public void testDuplicateZeros4() {
        int[] data = {1, 0, 0, 4, 5, 4, 0};
        new DuplicateZeros().duplicateZeros(data);
        assertEquals(data, new int[]{1, 0, 0, 0, 0, 4, 5});
    }

    @Test
    public void testDuplicateZeros5() {
        int[] data = {9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
        new DuplicateZeros().duplicateZeros(data);
        System.out.println(Arrays.toString(data));
        assertEquals(data, new int[]{9, 9, 9, 4, 8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 0, 0, 5, 6, 3, 1, 6, 0, 0, 0, 0, 2, 3, 4, 7, 0, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 0, 0, 7, 3, 3, 0, 0, 5, 7, 0, 0, 8, 1, 9, 6, 3, 0, 0, 8, 8, 8, 8, 0});
    }
}