package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SpecialArrayTest {

    @Test
    public void testSpecialArray1() {
        int result = new SpecialArray().specialArray(new int[]{3, 5});
        assertEquals(result, 2);
    }

    @Test
    public void testSpecialArray2() {
        int result = new SpecialArray().specialArray(new int[]{0, 0});
        assertEquals(result, -1);
    }

    @Test
    public void testSpecialArray3() {
        int result = new SpecialArray().specialArray(new int[]{0, 4, 3, 0, 4});
        assertEquals(result, 3);
    }

    @Test
    public void testSpecialArray4() {
        int result = new SpecialArray().specialArray(new int[]{3, 6, 7, 7, 0});
        assertEquals(result, -1);
    }

    @Test
    public void testSpecialArray5() {
        int result = new SpecialArray().specialArray(new int[]{6, 6, 6, 6, 6});
        assertEquals(result, 5);
    }

    @Test
    public void testSpecialArrayX() {
        int result = new SpecialArray().specialArray(new int[]{0});
        assertEquals(result, -1);

        result = new SpecialArray().specialArray(new int[]{123});
        assertEquals(result, 1);
    }
}