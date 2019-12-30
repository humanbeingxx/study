package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FactorialZerosTest {

    @Test
    public void testTrailingZeroes() {
        int result = new FactorialZeros().trailingZeroes(100);
        assertEquals(result, 24);
    }
}