package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class FairCandySwapTest {

    @Test
    public void testFairCandySwap() {
        int[] result = new FairCandySwap().fairCandySwap(new int[]{1, 1}, new int[]{2, 2});
        assertEquals(result, new int[]{1, 2});

        result = new FairCandySwap().fairCandySwap(new int[]{1, 2}, new int[]{2, 3});
        assertEquals(result, new int[]{1, 2});

        result = new FairCandySwap().fairCandySwap(new int[]{2}, new int[]{1, 3});
        assertEquals(result, new int[]{2, 3});

        result = new FairCandySwap().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        assertEquals(result, new int[]{5, 4});
    }

    @Test
    public void testFairCandySwap2() {
        int[] result = new FairCandySwap().fairCandySwap2(new int[]{1, 1}, new int[]{2, 2});
        assertEquals(result, new int[]{1, 2});

        result = new FairCandySwap().fairCandySwap2(new int[]{1, 2}, new int[]{2, 3});
        assertEquals(result, new int[]{1, 2});

        result = new FairCandySwap().fairCandySwap2(new int[]{2}, new int[]{1, 3});
        assertEquals(result, new int[]{2, 3});

        result = new FairCandySwap().fairCandySwap2(new int[]{1, 2, 5}, new int[]{2, 4});
        assertEquals(result, new int[]{5, 4});
    }
}