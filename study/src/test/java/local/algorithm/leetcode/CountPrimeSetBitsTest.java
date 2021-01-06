package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:36
 */
public class CountPrimeSetBitsTest {

    @Test
    public void testCountPrimeSetBits() {
        int result = new CountPrimeSetBits().countPrimeSetBits(10, 15);
        assertEquals(result, 5);
    }
}