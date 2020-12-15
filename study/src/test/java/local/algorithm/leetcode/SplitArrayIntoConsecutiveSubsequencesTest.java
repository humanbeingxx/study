package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SplitArrayIntoConsecutiveSubsequencesTest {

    @Test
    public void testIsPossible1() {
        boolean result = new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1,2,3,4,5,6});
        assertTrue(result);
    }

    @Test
    public void testIsPossible2() {
        boolean result = new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,5});
        assertTrue(result);
    }

    @Test
    public void testIsPossible3() {
        boolean result = new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1,2,3,3,4,4,5,5});
        assertTrue(result);
    }

    @Test
    public void testIsPossible4() {
        boolean result = new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1,2,3,4,4,5});
        assertFalse(result);
    }
}