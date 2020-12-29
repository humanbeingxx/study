package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HasValidPathTest {

    @Test
    public void testHasValidPath1() {
        boolean result = new HasValidPath().hasValidPath(new int[][]{
                {2, 4, 3},
                {6, 5, 2}
        });
        assertTrue(result);
    }

    @Test
    public void testHasValidPath2() {
        boolean result = new HasValidPath().hasValidPath(new int[][]{
                {1, 1, 1, 1, 1, 1, 3}
        });
        assertTrue(result);
    }

    @Test
    public void testHasValidPath3() {
        boolean result = new HasValidPath().hasValidPath(new int[][]{
                {2}, {2}, {2}, {2}, {2}, {2}, {6}
        });
        assertTrue(result);
    }

    @Test
    public void testHasValidPath4() {
        boolean result = new HasValidPath().hasValidPath(new int[][]{
                {1, 1, 1, 1, 6}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}, {1, 1, 1, 1, 2}
        });
        assertFalse(result);
    }
}