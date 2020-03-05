package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PossibleDivideTest {

    @Test
    public void testIsPossibleDivide1() {
        boolean result = new PossibleDivide().isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4);
        assertTrue(result);
    }

    @Test
    public void testIsPossibleDivide2() {
        boolean result = new PossibleDivide().isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3);
        assertTrue(result);
    }

    @Test
    public void testIsPossibleDivide3() {
        boolean result = new PossibleDivide().isPossibleDivide(new int[]{3,3,2,2,1,1}, 3);
        assertTrue(result);
    }

    @Test
    public void testIsPossibleDivide4() {
        boolean result = new PossibleDivide().isPossibleDivide(new int[]{1,2,3,2,3,5}, 3);
        assertFalse(result);
    }
}