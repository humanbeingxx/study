package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinimumSwapTest {

    @Test
    public void testMinimumSwap1() {
        int result = new MinimumSwap().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx");
        assertEquals(result, 4);
    }

    @Test
    public void testMinimumSwap2() {
        int result = new MinimumSwap().minimumSwap("xx", "yy");
        assertEquals(result, 1);
    }
}