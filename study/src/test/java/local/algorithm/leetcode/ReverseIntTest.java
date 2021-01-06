package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReverseIntTest {

    @Test
    public void testReverse1() {
        int result = new ReverseInt().reverse(123);
        assertEquals(result, 321);
    }

    @Test
    public void testReverse2() {
        int result = new ReverseInt().reverse(-123);
        assertEquals(result, -321);
    }

    @Test
    public void testReverse3() {
        int result = new ReverseInt().reverse(0);
        assertEquals(result, 0);
    }

    @Test
    public void testReverse4() {
        int result = new ReverseInt().reverse(-0);
        assertEquals(result, 0);
    }

    @Test
    public void testReverse5() {
        int result = new ReverseInt().reverse(-1234567899);
        assertEquals(result, 0);
    }

    @Test
    public void testReverse6() {
        int result = new ReverseInt().reverse(1234567899);
        assertEquals(result, 0);
    }
}