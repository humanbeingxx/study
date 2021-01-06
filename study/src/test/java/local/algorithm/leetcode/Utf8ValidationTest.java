package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Utf8ValidationTest {

    @Test
    public void testValidUtf8_0() {
        boolean result = new Utf8Validation().validUtf8(new int[]{});
        assertTrue(result);
    }

    @Test
    public void testValidUtf8_1() {
        boolean result = new Utf8Validation().validUtf8(new int[]{197, 130, 1});
        assertTrue(result);
    }

    @Test
    public void testValidUtf8_2() {
        boolean result = new Utf8Validation().validUtf8(new int[]{235, 140, 4});
        assertFalse(result);
    }

    @Test
    public void testValidUtf8_3() {
        boolean result = new Utf8Validation().validUtf8(new int[]{1, 1, 1, 1});
        assertTrue(result);
    }
}