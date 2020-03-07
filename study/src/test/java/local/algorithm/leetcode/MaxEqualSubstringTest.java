package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxEqualSubstringTest {

    @Test
    public void testEqualSubstring1() {
        int result = new MaxEqualSubstring().equalSubstring("abcd", "bcdf", 3);
        assertEquals(result, 3);
    }

    @Test
    public void testEqualSubstring2() {
        int result = new MaxEqualSubstring().equalSubstring("abcd", "cdef", 3);
        assertEquals(result, 1);
    }

    @Test
    public void testEqualSubstring3() {
        int result = new MaxEqualSubstring().equalSubstring("abcd", "acde", 0);
        assertEquals(result, 1);
    }

    @Test
    public void testEqualSubstring4() {
        int result = new MaxEqualSubstring().equalSubstring("krrgw", "zjxss", 19);
        assertEquals(result, 2);
    }
}