package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-16
 **/
public class ArrayPlusOneTest {

    @Test
    public void testPlusOne1() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{9});
        assertEquals(ints, new int[]{1, 0});
    }

    @Test
    public void testPlusOne2() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{1, 2, 3});
        assertEquals(ints, new int[]{1, 2, 4});
    }

    @Test
    public void testPlusOne3() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{9, 9, 9});
        assertEquals(ints, new int[]{1, 0, 0, 0});
    }

    @Test
    public void testPlusOne4() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{0});
        assertEquals(ints, new int[]{1});
    }

    @Test
    public void testPlusOne5() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{});
        assertEquals(ints, new int[]{});
    }

    @Test
    public void testPlusOne6() {
        int[] ints = new ArrayPlusOne().plusOne(new int[]{1, 9, 9, 9});
        assertEquals(ints, new int[]{2, 0, 0, 0});
    }

}