package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumDecodingsTest {

    @Test
    public void testNumDecodings1() {
        int result = new NumDecodings().numDecodings("226");
        assertEquals(result, 3);
    }

    @Test
    public void testNumDecodings2() {
        int result = new NumDecodings().numDecodings("123456789");
        assertEquals(result, 3);
    }

    @Test
    public void testNumDecodings3() {
        int result = new NumDecodings().numDecodings("110");
        assertEquals(result, 1);
    }

    @Test
    public void testNumDecodings4() {
        int result = new NumDecodings().numDecodings("011");
        assertEquals(result, 0);
    }

    @Test
    public void testNumDecodings5() {
        int result = new NumDecodings().numDecodings("100");
        assertEquals(result, 0);
    }

    @Test
    public void testNumDecodings6() {
        int result = new NumDecodings().numDecodings("101");
        assertEquals(result, 1);
    }

    @Test
    public void testNumDecodings7() {
        int result = new NumDecodings().numDecodings("230");
        assertEquals(result, 0);
    }
}