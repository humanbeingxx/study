package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainsPatternTest {

    @Test
    public void testContainsPattern1() {
        boolean result = new ContainsPattern().containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2);
        assertFalse(result);
    }

    @Test
    public void testContainsPattern2() {
        boolean result = new ContainsPattern().containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 4);
        assertTrue(result);
    }

    @Test
    public void testContainsPattern3() {
        boolean result = new ContainsPattern().containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2);
        assertTrue(result);
    }

    @Test
    public void testContainsPattern4() {
        boolean result = new ContainsPattern().containsPattern(new int[]{2, 2, 2, 2}, 2, 3);
        assertFalse(result);
    }
}