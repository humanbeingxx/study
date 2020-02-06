package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-05
 **/
public class MaximumSwapTest {

    @Test
    public void testMaximumSwap() {
        int result = new MaximumSwap().maximumSwap(2736);
        assertEquals(result, 7236);

        result = new MaximumSwap().maximumSwap(9973);
        assertEquals(result, 9973);

        result = new MaximumSwap().maximumSwap(122222);
        assertEquals(result, 222221);

        result = new MaximumSwap().maximumSwap(98368);
        assertEquals(result, 98863);
    }
}