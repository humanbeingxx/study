package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-13
 **/
public class NumSquaresTest {

    @Test
    public void testNumSquares() {
        int result = new NumSquares().numSquares(12);
        assertEquals(result, 3);

        result = new NumSquares().numSquares(123456);
        assertEquals(result, 3);
    }
}