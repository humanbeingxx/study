package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WiggleMaxLengthTest {

    @Test
    public void testWiggleMaxLength1() {
        int result = new WiggleMaxLength().wiggleMaxLength(new int[]{1, 2, 1, 2, 1, 2});
        assertEquals(result, 6);
    }

    @Test
    public void testWiggleMaxLength2() {
        int result = new WiggleMaxLength().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        assertEquals(result, 7);
    }

    @Test
    public void testWiggleMaxLength3() {
        int result = new WiggleMaxLength().wiggleMaxLength(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 2);
    }

    @Test
    public void testWiggleMaxLength4() {
        int result = new WiggleMaxLength().wiggleMaxLength(new int[]{1, 1,1});
        assertEquals(result, 1);
    }

    @Test
    public void testWiggleMaxLength5() {
        int result = new WiggleMaxLength().wiggleMaxLength(new int[]{1, 1});
        assertEquals(result, 1);
    }
}