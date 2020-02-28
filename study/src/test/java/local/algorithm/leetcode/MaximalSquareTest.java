package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaximalSquareTest {

    @Test
    public void testMaximalSquare() {
        int result = new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
        assertEquals(result, 4);
    }
}