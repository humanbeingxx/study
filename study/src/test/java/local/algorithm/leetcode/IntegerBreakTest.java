package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntegerBreakTest {

    @Test
    public void testIntegerBreak() {
        int result = new IntegerBreak().integerBreak(8);
        assertEquals(result, 18);
    }
}